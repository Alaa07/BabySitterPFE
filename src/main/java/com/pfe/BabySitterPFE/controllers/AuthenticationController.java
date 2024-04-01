package com.pfe.BabySitterPFE.controllers;

import com.pfe.BabySitterPFE.authentication.AuthenticationRequest;
import com.pfe.BabySitterPFE.authentication.AuthenticationResponse;
import com.pfe.BabySitterPFE.authentication.RegisterRequest;
import com.pfe.BabySitterPFE.entities.User;
import com.pfe.BabySitterPFE.services.AuthenticationService;
import com.pfe.BabySitterPFE.services.PasswordResetService;
import com.pfe.BabySitterPFE.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final PasswordResetService passwordResetService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    } 

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
     ) throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam("email") String userEmail, HttpServletRequest request) {
        User user = userService.findUserByEmail(userEmail);
        if (user != null) {
            String token = UUID.randomUUID().toString();
            passwordResetService.createPasswordResetTokenForUser(user, token);
            passwordResetService.sendResetTokenEmail(getAppUrl(request), request.getLocale(), token, user);
        }
        return new ResponseEntity<>("Reset link sent if email exists", HttpStatus.OK);
    }
    // Endpoint to confirm the password reset
    @GetMapping("/reset-password")
    public String displayResetPasswordPage(@RequestParam("token") String token) {
        String result = passwordResetService.validatePasswordResetToken(token);
        if(result != null) {
            // Token validation failed
            return "redirect:/login?error=" + result;
        } else {
            // Token valid, show reset password form
            return "resetPasswordPage";
        }
    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam("token") String token,
                                           @RequestParam("password") String newPassword) {
        String result = passwordResetService.validatePasswordResetToken(token);
        if(result != null) {
            // Token validation failed
            return new ResponseEntity<>("Invalid Token", HttpStatus.BAD_REQUEST);
        }
        Optional<User> user = passwordResetService.getUserByPasswordResetToken(token);
        if(user.isPresent()) {
            userService.changePassword(user.get(), newPassword); // Corrected to match the expected parameters
            return new ResponseEntity<>("Password reset successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Token", HttpStatus.BAD_REQUEST);
        }
    }


    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
