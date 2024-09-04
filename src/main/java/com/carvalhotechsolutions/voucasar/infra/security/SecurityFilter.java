package com.carvalhotechsolutions.voucasar.infra.security;

import com.carvalhotechsolutions.voucasar.models.user.User;
import com.carvalhotechsolutions.voucasar.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    final TokenService tokenService;
    final UserRepository userRepository;

    private static final List<String> EXCLUDED_PATHS = List.of("auth/login", "auth/register");

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        addSecurityHeaders(response);

        var token = this.recoverToken(request);
        if (token == null || token.isEmpty()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Token is missing or empty");
            return;
        }
        try {
            var login = tokenService.validateToken(token);
            User user = userRepository.findByEmail(login).orElseThrow(() -> new RuntimeException("User not found"));

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Invalid token");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return EXCLUDED_PATHS.stream().anyMatch(path::contains);
    }

    //    Add security headers to the response
    private void addSecurityHeaders(HttpServletResponse response) {
//        Content Security Policy -> Restringe as fontes de conteúdo que podem ser carregadas.
        response.setHeader("Content-Security-Policy", "default-src 'self'");
//        X-Content-Type-Options -> Previne que o navegador interprete tipos de conteúdo incorretamente.
        response.setHeader("X-Content-Type-Options", "nosniff");
//        X-Frame-Options -> Protege contra ataques de clickjacking, prevenindo o conteúdo de ser carregado dentro de iframes.
        response.setHeader("X-Frame-Options", "DENY");
//        Strict-Transport-Security -> Assegura que todas as conexões sejam feitas via HTTPS, configurando um período de validade para essa política.
        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");
    }

    //        Recover the token from the request header
    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || authHeader.isEmpty())
            return null;

        return authHeader.replace("Bearer ", "");
    }
}
