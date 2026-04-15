package demo.demo.controller.movement;

import demo.demo.service.movement.MovementDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movements")
public class MovementDeleteController {
    //Instanciar y Inicializar

    //Instanciar
    private final MovementDeleterService movementDeleterService;

    //Constructor
    public MovementDeleteController(MovementDeleterService movementDeleterService){
        this.movementDeleterService = movementDeleterService;
    }

    //Anotacion de Mapping. vamos a usar el ID que viene desde la URL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ //Siempre devolvemos un ResponseEntity desde el controller
        movementDeleterService.delete(id); //Usamos la funcion creada del service
        return ResponseEntity.noContent().build(); //No content porque es void, build para que sea una entidad
    }
}
