package demo.demo.dto.request.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    @Nullable
    private Long dni;

    public UserRequest(){};
    public UserRequest(String username, String email, String password, @Nullable Long dni) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Nullable
    public Long getDni() {
        return dni;
    }
}
