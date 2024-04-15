package com.pfe.BabySitterPFE.user;


import com.pfe.BabySitterPFE.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_USER")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private Boolean accountLocked;
    private Boolean enabled;
    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    //Parent specific attributes :
    private Integer childNB;
    private Integer childAge;
    private String specific_needs;
    private String  address;
    private String location;


    //BabySitter specific attributes :
    private String availability;
    private String hourlyRate;
    private String experience;
    private String competence;
    private String description;
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public User(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(int id,
                String firstName,
                String lastName,
                String email,
                String password,
                Integer childNB,
                Integer childAge,
                String specific_needs,
                String address,
                String location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.childNB = childNB;
        this.childAge = childAge;
        this.specific_needs = specific_needs;
        this.address = address;
        this.location = location;
    }

    public User(int id,
                String firstName,
                String lastName,
                String email,
                String password,
                String availability,
                String hourlyRate,
                String experience,
                String competence,
                String description,
                String photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.availability = availability;
        this.hourlyRate = hourlyRate;
        this.experience = experience;
        this.competence = competence;
        this.description = description;
        this.photo = photo;
    }

    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r->new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    private String fullName(){
        return firstName+" "+lastName;
    }
}
