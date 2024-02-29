package com.pfe.authsecurity.Parent;

import java.util.Set;

public record ParentRecord(Long idParent, String firstName, String lastName, String email, String password,
                           Set<String> roles, String maritalStatus, int numberOfChildren, String location) {
}
