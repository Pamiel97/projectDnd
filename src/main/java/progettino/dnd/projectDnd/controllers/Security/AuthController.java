package progettino.dnd.projectDnd.controllers.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import progettino.dnd.projectDnd.dtos.security.AuthenticationRequest;
import progettino.dnd.projectDnd.dtos.security.AuthenticationResponse;
import progettino.dnd.projectDnd.dtos.security.RegisterRequest;
import progettino.dnd.projectDnd.model.entities.Role;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.repositories.security.RoleRepository;
import progettino.dnd.projectDnd.model.repositories.security.UserRepository;
import progettino.dnd.projectDnd.model.services.security.AuthService;

import java.util.Set;
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final AuthService service;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthService service, RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @PostMapping("/register2")
    public ResponseEntity<AuthenticationResponse> register2(@RequestBody RegisterRequest request) {
        AuthenticationResponse response = service.register(request);
        return ResponseEntity.ok(response);
    }




    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        // Trova il ruolo corrispondente nel database usando il nome del ruolo fornito
        Role role = roleRepository.findByName(registerRequest.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Crea un nuovo utente con i dettagli forniti e il ruolo trovato
        User user = new User(
                registerRequest.getFirstname(),
                registerRequest.getLastname(),
                registerRequest.getEmail(),
                passwordEncoder.encode(registerRequest.getPassword()), // Codifica la password
                Set.of(role)  // Converte il ruolo in un Set per essere compatibile con il costruttore
        );

        // Salva l'utente nel repository
        userRepository.save(user);

        // Restituisce una risposta positiva
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }
}