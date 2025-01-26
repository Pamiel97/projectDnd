package progettino.dnd.projectDnd.controllers.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import progettino.dnd.projectDnd.dtos.security.AuthenticationRequest;
import progettino.dnd.projectDnd.dtos.security.AuthenticationResponse;
import progettino.dnd.projectDnd.dtos.security.RegisterRequest;
import progettino.dnd.projectDnd.model.services.security.AuthService;

@RestController
public class AuthController {
    private final AuthService service;
    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }
}