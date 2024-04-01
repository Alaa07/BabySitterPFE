package com.pfe.BabySitterPFE.services;

import com.pfe.BabySitterPFE.entities.User;
import com.pfe.BabySitterPFE.passwords.ChangePasswordRequest;
import com.pfe.BabySitterPFE.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    public User findUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Integer id, User updatedUser) {
        User existingUser = repository.findById(id).orElse(null);
        if (existingUser != null) {
            updatedUser.setId(id);
            return repository.save(updatedUser);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }
    public void changePassword(User user, String newPassword) {
        // Encode the new password
        String encodedPassword = passwordEncoder.encode(newPassword);

        // Update the user's password
        user.setPassword(encodedPassword);

        // Save the new password
        repository.save(user);
    }
}
