package com.carvalhotechsolutions.voucasar.repositories;

import com.carvalhotechsolutions.voucasar.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}