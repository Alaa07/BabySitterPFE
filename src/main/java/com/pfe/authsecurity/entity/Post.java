package com.pfe.authsecurity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Post")

public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPost;

    //  @NaturalId(mutable = true)
    private String subject;
    private String content;
    private Date publicationDate;
    private  String user;
}
