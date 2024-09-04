package com.carvalhotechsolutions.voucasar.models.user;

import com.carvalhotechsolutions.voucasar.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank(message = "Email is required") String email,
        @NotBlank(message = "Password is required") String password,
        @NotNull(message = "Role is required") UserRole role
) {
}
