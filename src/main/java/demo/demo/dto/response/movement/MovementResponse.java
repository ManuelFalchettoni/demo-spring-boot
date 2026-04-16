package demo.demo.dto.response.movement;

public class MovementResponse {
    //Instanciar
    private Long id;
    private String name;
    private String description;

    //Los DTOs por defecto tienen dos constructores
    public MovementResponse() {};

    public MovementResponse(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //Getters y setters
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
