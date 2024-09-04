package com.carvalhotechsolutions.voucasar.controllers;

import com.carvalhotechsolutions.voucasar.infra.security.TokenService;
import com.carvalhotechsolutions.voucasar.models.user.*;
import com.carvalhotechsolutions.voucasar.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (userRepository.findByEmail(registerDTO.email()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(registerDTO.email(), encryptedPassword, registerDTO.role());

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(newUser));

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        if (tokenService.isAccountLocked(authenticationDTO.email())) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }

        try {
            var usernamePasswordToken = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
            var auth = authenticationManager.authenticate(usernamePasswordToken);
            User userAuthenticated = (User) auth.getPrincipal();

            var tokenUser = tokenService.generateToken(userAuthenticated);

            userRepository.save(userAuthenticated);

            LoginResponseDTO responseDTO = new LoginResponseDTO(
                    userAuthenticated.getEmail(),
                    userAuthenticated.getRole(),
                    tokenUser
            );

            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (BadCredentialsException ex) {
            tokenService.registerFailedAttempt(authenticationDTO.email());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (LockedException ex) {
            return ResponseEntity.status(HttpStatus.LOCKED).build();
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
