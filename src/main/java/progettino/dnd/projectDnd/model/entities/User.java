package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;

//cascade: Usalo se vuoi che le operazioni sull'entità principale influenzino automaticamente le entità figlie.
//orphanRemoval: Usalo se vuoi che le entità figlie non collegate vengano automaticamente eliminate dal database.



@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<CharacterPg> pgs;
}
