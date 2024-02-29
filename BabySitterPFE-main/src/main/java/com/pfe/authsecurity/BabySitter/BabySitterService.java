package com.pfe.authsecurity.BabySitter;

import com.pfe.authsecurity.Parent.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BabySitterService {
    private final BabySitterRepository babySitterRepository;

    @Autowired
    public BabySitterService(BabySitterRepository babySitterRepository) {
        this.babySitterRepository = babySitterRepository;
    }

    public List<BabySitter> getAllBabysitters() {
        return babySitterRepository.findAll();
    }

    public BabySitter getBabySitterById(Long babySitterId) {
        return babySitterRepository.findById(babySitterId)
                .orElseThrow(() -> new CustomNotFoundException("Babysitter not found"));
    }

    public BabySitter createBabysitter(BabySitter babysitter) {
        return babySitterRepository.save(babysitter);
    }

    public BabySitter updateBabysitter(Long babysitterId, BabySitter babysitter) {
        BabySitter existingBabysitter = babySitterRepository.findById(babysitterId)
                .orElseThrow(() -> new CustomNotFoundException("Babysitter not found"));
        // Mise à jour des attributs du babysitter existant avec les valeurs du babysitter fourni
        existingBabysitter.setGender(babysitter.getGender());
        existingBabysitter.setLanguage(babysitter.getLanguage());
        existingBabysitter.setExperienceWithSpecialNeeds(babysitter.getExperienceWithSpecialNeeds());
        existingBabysitter.setAnimalAllergy(babysitter.isAnimalAllergy());
        existingBabysitter.setDurationOfExperience(babysitter.getDurationOfExperience());
        existingBabysitter.setLocation(babysitter.getLocation());
        existingBabysitter.setAvailability(babysitter.getAvailability());
        return babySitterRepository.save(existingBabysitter);
    }




    public void deleteBabySitter(Long babysitterId) {
        if (!babySitterRepository.existsById(babysitterId)) {
            throw new CustomNotFoundException("Babysitter not found");
        }
        babySitterRepository.deleteById(babysitterId);
    }
}
