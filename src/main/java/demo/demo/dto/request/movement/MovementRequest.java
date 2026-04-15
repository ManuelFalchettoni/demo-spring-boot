package demo.demo.dto.request.movement;

//En el DTO nunco pongo mi auto incremental
public class MovementRequest {
    //Instanciar
    private String name;
    private String description;

    //Inicializar constructores
    //Uno vacio
    public MovementRequest(){}

    //Otro completo
    public MovementRequest(String name, String description){
        this.name = name;
        this.description = description;
    }

    //Getters y Setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
