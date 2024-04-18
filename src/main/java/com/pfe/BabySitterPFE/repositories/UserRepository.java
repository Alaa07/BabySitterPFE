package com.pfe.BabySitterPFE.repositories;

import com.pfe.BabySitterPFE.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
