package com.pfe.BabySitterPFE.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long message_id;
    private String sender;
    private String recipient;
    private String subject;
    private String content;
    private Date sendDate;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "babySitter_id")
    private BabySitter babySitter;

}
