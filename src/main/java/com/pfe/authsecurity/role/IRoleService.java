package com.pfe.authsecurity.role;

import com.pfe.authsecurity.user.User;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    Role createRole(Role theRole);
    void deleteRole(Long roleId);
    Role findByName(String name);
    Role findById(Long roelId);
    User removeUserFromRole(Long userId, Long roleId);
    User assignUerToRole(Long userId, Long roleId);
    Role removeAllUserFromRole(Long roleId);
}
