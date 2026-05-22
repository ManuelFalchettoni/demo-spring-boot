package demo.demo.dto.response.user;



public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private Long dni;

    public UserResponse(){};
    public UserResponse(Long id, String username, String email, Long dni) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dni = dni;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Long getDni() {
        return dni;
    }
}
