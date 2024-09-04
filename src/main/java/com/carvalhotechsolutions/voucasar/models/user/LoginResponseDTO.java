package com.carvalhotechsolutions.voucasar.models.user;

import com.carvalhotechsolutions.voucasar.enums.UserRole;

public record LoginResponseDTO(
        String email,
        UserRole role,
        String token
) {
}
