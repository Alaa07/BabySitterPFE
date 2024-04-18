package com.pfe.BabySitterPFE.users;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BABYSITTER")
@EntityListeners(AuditingEntityListener.class)
public class BabySitter extends User{
    private String availability;
    private String hourlyRate;
    private String experience;
    private String competence;
    private String description;
    private String photo;

    public BabySitter(Long id, String firstName, String lastName, String email, String password, Role role, String availability, String hourlyRate, String experience, String competence, String description, String photo) {
        super(id, firstName, lastName, email, password, role);
        this.availability = availability;
        this.hourlyRate = hourlyRate;
        this.experience = experience;
        this.competence = competence;
        this.description = description;
        this.photo = photo;
    }
}
