package progettino.dnd.projectDnd.model.services.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.security.AuthenticationRequest;
import progettino.dnd.projectDnd.dtos.security.AuthenticationResponse;
import progettino.dnd.projectDnd.dtos.security.RegisterRequest;
import progettino.dnd.projectDnd.model.entities.Role;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.repositories.security.RoleRepository;
import progettino.dnd.projectDnd.model.repositories.security.UserRepository;

import java.util.Set;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, UserRepository repository, AuthenticationManager authenticationManager, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
    }


//    public AuthenticationResponse register(RegisterRequest request) {
//        logger.info("Register method called with request: {}", request);
//
//        User user = new User(request.getFirstname(), request.getLastname(), request.getEmail(), passwordEncoder.encode(request.getPassword()),request.getRole());
//        repository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return new AuthenticationResponse(jwtToken);
//    }


    public AuthenticationResponse register(RegisterRequest request) {
        logger.info("Register method called with request: {}", request);

        // Trova il ruolo nel database tramite il nome del ruolo passato nella richiesta
        Role role = roleRepository.findByName(request.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Crea un nuovo utente con i dettagli forniti e il ruolo trovato
        User user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()), // Codifica la password
                Set.of(role)  // Passa il ruolo come un Set di ruoli
        );

        // Salva l'utente nel repository
        repository.save(user);

        // Genera un token JWT
        var jwtToken = jwtService.generateToken(user);

        // Restituisci la risposta con il token
        return new AuthenticationResponse(jwtToken);
    }




    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);

    }
}
