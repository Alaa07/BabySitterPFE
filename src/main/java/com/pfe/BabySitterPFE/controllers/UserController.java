package com.pfe.BabySitterPFE.controllers;

import com.pfe.BabySitterPFE.DTO.AuthenticationRequest;
import com.pfe.BabySitterPFE.DTO.BabysitterRegistrationRequest;
import com.pfe.BabySitterPFE.DTO.ParentRegistrationRequest;
import com.pfe.BabySitterPFE.repositories.UserRepository;
import com.pfe.BabySitterPFE.services.BabysitterService;
import com.pfe.BabySitterPFE.services.ParentService;
import com.pfe.BabySitterPFE.users.BabySitter;
import com.pfe.BabySitterPFE.users.Parent;
import com.pfe.BabySitterPFE.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private ParentService parentService;

    @Autowired
    private BabysitterService babysitterService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register/parent")
    public ResponseEntity<?> registerParent(@RequestBody ParentRegistrationRequest request) {
        try {
            Parent parent = parentService.registerParent(request);
            return ResponseEntity.ok(parent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register parent: " + e.getMessage());
        }
    }

    @PostMapping("/register/babysitter")
    public ResponseEntity<?> registerBabysitter(@RequestBody BabysitterRegistrationRequest request) {
        try {
            BabySitter babySitter = babysitterService.registerBabysitter(request);
            return ResponseEntity.ok(babySitter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register babysitter: " + e.getMessage());
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                    // Authentication successful
                    return ResponseEntity.ok("Authentication successful for user: " + user.getEmail());
                } else {
                    // Incorrect password
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
                }
            } else {
                // User not found
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to authenticate: " + e.getMessage());
        }
    }
}
