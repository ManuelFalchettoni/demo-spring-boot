package demo.demo.exception.movement;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //Response con el tipo de respuesta
public class MovementNotFoundException extends RuntimeException{ //Extender des las exceptions de Java

    //Metodo MAGICO constructor
    public MovementNotFoundException(Long id){
        super("Movement not found" + id);
    }
}
