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
@Table(name = "PARENT")
@EntityListeners(AuditingEntityListener.class)
public class Parent extends User{
    private Integer childNB;
    private Integer childAge;
    public String specificNeeds;
    private String  address;
    private String location;

    public Parent(Long id,
                  String firstName,
                  String lastName,
                  String email,
                  String password,
                  Role role,
                  Integer childNB,
                  Integer childAge,
                  String specificNeeds,
                  String address,
                  String location) {
        super(id, firstName, lastName, email, password, role);
        this.childNB = childNB;
        this.childAge = childAge;
        this.specificNeeds = specificNeeds;
        this.address = address;
        this.location = location;
    }
}
