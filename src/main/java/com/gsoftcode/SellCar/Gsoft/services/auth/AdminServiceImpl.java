package com.gsoftcode.SellCar.Gsoft.services.auth;

import com.gsoftcode.SellCar.Gsoft.entities.User;
import com.gsoftcode.SellCar.Gsoft.enums.UserRole;
import com.gsoftcode.SellCar.Gsoft.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl {

    private final UserRepository userRepository;

    public void createAnAdminAccount(){
        Optional<User> optionalAdmin = userRepository.findByUserRole(UserRole.ADMIN);
        if (optionalAdmin.isEmpty()){
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@test.com");
            admin.setUserRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);
            System.out.println("Admin account created successfully");
        }else {
            System.out.println("Admin account already exist!");
        }
    }
}
