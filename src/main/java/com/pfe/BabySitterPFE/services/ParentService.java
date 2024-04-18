package com.pfe.BabySitterPFE.services;

import com.pfe.BabySitterPFE.DTO.ParentRegistrationRequest;
import com.pfe.BabySitterPFE.repositories.UserRepository;
import com.pfe.BabySitterPFE.users.Parent;
import com.pfe.BabySitterPFE.users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Parent registerParent(ParentRegistrationRequest request) {
        Parent parent = new Parent();
        parent.setFirstName(request.getFirstName());
        parent.setLastName(request.getLastName());
        parent.setEmail(request.getEmail());
        parent.setPassword(passwordEncoder.encode(request.getPassword())); // Encode password
        parent.setChildNB(request.getChildNB());
        parent.setChildAge(request.getChildAge());
        parent.setSpecificNeeds(request.getSpecificNeeds());
        parent.setAddress(request.getAddress());
        parent.setLocation(request.getLocation());
        parent.setRole(Role.PARENT);
        return userRepository.save(parent);
    }
}
