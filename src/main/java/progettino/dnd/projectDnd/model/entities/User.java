package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<CharacterPg> pgs;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;



    //COSTRUTTORI E GETTER/SETTER

    public User(){

    }
    public User(long id, String firstname, String lastname, String email, String password, List<CharacterPg> pgs, Set<Role> roles) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.pgs = pgs;
        this.roles = roles;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CharacterPg> getPgs() {
        return pgs;
    }

    public void setPgs(List<CharacterPg> pgs) {
        this.pgs = pgs;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
