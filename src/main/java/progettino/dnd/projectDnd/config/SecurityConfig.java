package progettino.dnd.projectDnd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import progettino.dnd.projectDnd.model.services.implementation.UserDetail;

@Configuration
public class SecurityConfig {
    private final UserDetail userDetailsService;

    public SecurityConfig(UserDetail userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Cripta le password
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

        return authManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**").permitAll() // Accesso pubblico
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Accesso solo agli ADMIN
                        .requestMatchers("/api/moderator/**").hasRole("MODERATOR") // Accesso solo ai MODERATOR
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "MODERATOR", "ADMIN") // Accesso a utenti, moderatori e admin
                        .anyRequest().authenticated() // Tutti gli altri endpoint richiedono autenticazione
                )
                .formLogin(form -> form
                        .loginPage("/login") // Pagina di login personalizzata
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );

        return http.build();
    }
}
