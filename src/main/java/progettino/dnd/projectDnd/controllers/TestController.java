package progettino.dnd.projectDnd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // Endpoint pubblico (accessibile senza autenticazione)
    @GetMapping("/api/public/any")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    // Endpoint protetto da admin
    @GetMapping("/api/admin/any")
    public String adminEndpoint() {
        return "This is an admin endpoint";
    }

    // Endpoint protetto da moderator
    @GetMapping("/api/moderator/any")
    public String moderatorEndpoint() {
        return "This is a moderator endpoint";
    }

    // Endpoint protetto da user, moderator o admin
    @GetMapping("/api/user/any")
    public String userEndpoint() {
        return "This is a user endpoint";
    }
}
