package demo.demo.controller.movement;

import demo.demo.dto.request.movement.MovementRequest;
import demo.demo.dto.response.movement.MovementResponse;
import demo.demo.mapper.movement.MovementMapper;
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
    public ResponseEntity<MovementResponse> create(@RequestBody MovementRequest movementRequest){
        Movement savedMovement = movementCreatorService.create(movementRequest);
        MovementResponse response = MovementMapper.convertor(savedMovement);
        return ResponseEntity.status(HttpStatus.CREATED).body(response); //Devolvemos Response con status, a traves del body, utilizando el service de creator
    }
}
