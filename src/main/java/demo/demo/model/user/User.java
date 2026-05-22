package demo.demo.model.user;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String username;
    @NotBlank
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Size(min = 8)
    @Column(nullable = false)
    private String password;
    @Nullable
    private Long dni;

    public User(){}
    public User(String username, String email, String password, @Nullable Long dni){
        this.username = username;
        this.email = email;
        this.password = password;
        this.dni = dni;
    }
    //Getters
    public Long getId(){return id;}
    @Nullable
    public Long getDni() {return dni;}
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}

    public void setUsername(String username) {this.username = username;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setDni(@Nullable Long dni) {this.dni = dni;}
}
