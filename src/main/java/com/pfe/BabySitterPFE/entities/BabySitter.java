package com.pfe.BabySitterPFE.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_BabySitter")
public class BabySitter  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_babySitter;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String availability;
    private String hourlyRate;
    private String experience;
    private String competence;
    private String description;
    private String photo;
    @OneToMany(mappedBy = "babySitter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "babySitter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

}
