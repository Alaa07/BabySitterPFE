package com.pfe.BabySitterPFE.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_post;
    //  @NaturalId(mutable = true)
    private String subject;
    private String content;
    private Date publicationDate;
    private  String user;

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private Parent parent;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

}
