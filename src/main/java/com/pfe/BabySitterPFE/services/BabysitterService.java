package com.pfe.BabySitterPFE.services;

import com.pfe.BabySitterPFE.DTO.BabysitterRegistrationRequest;
import com.pfe.BabySitterPFE.repositories.UserRepository;
import com.pfe.BabySitterPFE.users.BabySitter;
import com.pfe.BabySitterPFE.users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BabysitterService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public BabySitter registerBabysitter(BabysitterRegistrationRequest request) {
        BabySitter babySitter = new BabySitter();
        babySitter.setFirstName(request.getFirstName());
        babySitter.setLastName(request.getLastName());
        babySitter.setEmail(request.getEmail());
        babySitter.setPassword(passwordEncoder.encode(request.getPassword())); // Encode password
        babySitter.setAvailability(request.getAvailability());
        babySitter.setHourlyRate(request.getHourlyRate());
        babySitter.setExperience(request.getExperience());
        babySitter.setCompetence(request.getCompetence());
        babySitter.setDescription(request.getDescription());
        babySitter.setPhoto(request.getPhoto());
        babySitter.setRole(Role.BABYSITTER);
        return userRepository.save(babySitter);
    }
}
