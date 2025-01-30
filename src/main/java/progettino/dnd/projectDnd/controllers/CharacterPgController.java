package progettino.dnd.projectDnd.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@Validated
public class CharacterPgController {

}
