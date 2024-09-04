package com.carvalhotechsolutions.voucasar.models.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank(message = "Email cannot be null") String email,
        @NotBlank(message = "Password cannot be null") String password
) {
}