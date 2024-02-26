package com.pfe.BabySitterPFE.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    BABYSITTER_READ("babySitter:read"),
    BABYSITTER_UPDATE("babySitter:update"),
    BABYSITTER_CREATE("babySitter:create"),
    BABYSITTER_DELETE("babySitter:delete"),
    PARENT_READ("parent:read"),
    PARENT_UPDATE("parent:update"),
    PARENT_CREATE("parent:create"),
    PARENT_DELETE("parent:delete")
;
    @Getter
    private final String permission;
}

