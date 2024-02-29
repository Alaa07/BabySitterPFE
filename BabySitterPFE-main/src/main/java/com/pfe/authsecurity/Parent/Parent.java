package com.pfe.authsecurity.Parent;

import com.pfe.authsecurity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "parents") // Nom de la table pour les parents

public class Parent extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NaturalId
    private Long idParent;
    private String maritalStatus;
    private int numberOfChildren;
    private String location;

    //@OneToMany(mappedBy = "parent")
   // private List<Child> children;

   // public Parent() {
      //  setRole("parent");
    //}

}

