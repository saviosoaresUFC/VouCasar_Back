package com.carvalhotechsolutions.voucasar.models.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoginAttempt {
    private int attempts;
    private LocalDateTime lastAttemptTime;

    public LoginAttempt(int attempts, LocalDateTime lastAttemptTime) {
        this.attempts = attempts;
        this.lastAttemptTime = lastAttemptTime;
    }

    public void incrementAttempts() {
        this.attempts++;
    }
}