package com.pfe.BabySitterPFE.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register-Parent")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> registerParent(
            @RequestBody @Valid RegistrationParentRequest request
    ) {
        service.registerParent(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register-BabySitter")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> registerBabySitter(
            @RequestBody @Valid RegistrationBabySitterRequest request
    ) {
        service.registerBabySitter(request) ;
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticateUser")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody @Valid AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

