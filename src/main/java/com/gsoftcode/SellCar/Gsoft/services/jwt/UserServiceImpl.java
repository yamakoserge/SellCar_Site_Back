package com.gsoftcode.SellCar.Gsoft.services.jwt;


import com.gsoftcode.SellCar.Gsoft.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailService() {
        return email -> userRepository.findFirstByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
