package com.pfe.BabySitterPFE.auth;

import com.pfe.BabySitterPFE.role.RoleRepository;
import com.pfe.BabySitterPFE.security.JwtService;
import com.pfe.BabySitterPFE.user.Token;
import com.pfe.BabySitterPFE.user.TokenRepository;
import com.pfe.BabySitterPFE.user.User;
import com.pfe.BabySitterPFE.user.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    //private final Token token;


    private final TokenRepository tokenRepository;
    public void registerParent(RegistrationParentRequest request) {
        var userRole =roleRepository.findByName("PARENT")

                .orElseThrow(()-> new IllegalStateException("ROLE PARENT was not initialized"));
        var user= User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .childNB(request.getChildNB())
                .childAge(request.getChildAge())
                .address(request.getAddress())
                .specific_needs(request.getSpecific_needs())
                .accountLocked(true)
                .enabled(true)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);


    }


    public void registerBabySitter(RegistrationBabySitterRequest request) {
        var userRole =roleRepository.findByName("BABYSITTER")

                .orElseThrow(()-> new IllegalStateException("ROLE BABYSITTER was not initialized"));
        var user= User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .availability(request.getAvailability())
                .hourlyRate(request.getHourlyRate())
                .experience(request.getExperience())
                .competence(request.getCompetence())
                .description(request.getDescription())
                .photo(request.getPhoto())
                .accountLocked(true)
                .enabled(true)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);


    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }




}
