package com.gsoftcode.SellCar.Gsoft.repository;

import com.gsoftcode.SellCar.Gsoft.entities.User;
import com.gsoftcode.SellCar.Gsoft.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    Optional<User> findByUserRole(UserRole userRole);
}
