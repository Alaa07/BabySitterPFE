package com.pfe.authsecurity.BabySitter;

import com.pfe.authsecurity.user.User;
import jakarta.persistence.*;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class BabySitter extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBabySitter;

    private String gender;
    private String language;
    private String experienceWithSpecialNeeds;
    private boolean animalAllergy;
    private String durationOfExperience;
    private String location;
    private String availability;


}

