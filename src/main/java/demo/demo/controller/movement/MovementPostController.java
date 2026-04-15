package demo.demo.controller.movement;

import demo.demo.dto.request.movement.MovementRequest;
import demo.demo.model.movement.Movement;
import demo.demo.service.movement.MovementCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/movements") //Todas las rutas van a estar en plural, porque en la DB estan en plural
public class MovementPostController {
    //Instanciar
    private final MovementCreatorService movementCreatorService;

    //Inicializar con cosntructor
    public MovementPostController(MovementCreatorService movementCreatorService){
        this.movementCreatorService = movementCreatorService;
    }

    @PostMapping //Mapping con el tipo de request que estamos usando
    public ResponseEntity<Movement> create(@RequestBody MovementRequest movementRequest){
        Movement movement= new Movement(); //   Nueva entidad
        movement.setName(movementRequest.getName()); // Set name
        movement.setDescription(movementRequest.getDescription()); //Set description
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movementCreatorService.create(movement)); //Devolvemos Response con status, a traves del body, utilizando el service de creator
    }
}
