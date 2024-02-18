package com.pfe.authsecurity.user;

import com.pfe.authsecurity.role.Role;

import java.util.Set;

public record UserRecord(Long id, String firstName, String lastName, String email, Set<Role> roles){

}

