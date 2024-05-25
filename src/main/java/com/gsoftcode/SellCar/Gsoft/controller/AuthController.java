package com.gsoftcode.SellCar.Gsoft.controller;

import com.gsoftcode.SellCar.Gsoft.dtos.AuthenticationRequest;
import com.gsoftcode.SellCar.Gsoft.dtos.AuthenticationResponse;
import com.gsoftcode.SellCar.Gsoft.dtos.SignupRequest;
import com.gsoftcode.SellCar.Gsoft.dtos.UserDTO;
import com.gsoftcode.SellCar.Gsoft.entities.User;
import com.gsoftcode.SellCar.Gsoft.repository.UserRepository;
import com.gsoftcode.SellCar.Gsoft.services.auth.AuthService;
import com.gsoftcode.SellCar.Gsoft.services.jwt.UserService;
import com.gsoftcode.SellCar.Gsoft.utils.JWTUtil;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    private final JWTUtil jwtUtil;

    private final UserService userService;

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
        if (authService.hasUserWithEmail(signupRequest.getEmail()))
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ce Compte existe deja, ");
        UserDTO userDTO = authService.signup(signupRequest);
        if (userDTO == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

   @GetMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()));


    }catch (BadCredentialsException e){
            throw new BadCredentialsException("Login ou Mot de passe sont incorrectes");
        }

final UserDetails userDetails = userService.userDetailService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        AuthenticationResponse response = new AuthenticationResponse();
        if (optionalUser.isPresent()){
            response.setJwt(jwt);
            response.setUserRole(optionalUser.get().getUserRole());
            response.setUserId(optionalUser.get().getId());
        }
        return response;

    }
}
