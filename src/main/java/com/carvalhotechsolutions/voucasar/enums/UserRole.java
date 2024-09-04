package com.carvalhotechsolutions.voucasar.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    COUPLE("couple"),
    GUEST("guest"),
    ADMIN("admin");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}