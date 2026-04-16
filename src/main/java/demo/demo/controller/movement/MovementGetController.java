package demo.demo.controller.movement;

import demo.demo.dto.response.movement.MovementResponse;
import demo.demo.mapper.movement.MovementMapper;
import demo.demo.model.movement.Movement;
import demo.demo.service.movement.MovementFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movements")
public class
MovementGetController {
    //Instanciar
    private final MovementFinderService movementFinderService;
    private final MovementMapper movementMapper;
    //Inicializar con constructor
    public MovementGetController(MovementFinderService movementFinderService, MovementMapper movementMapper){
        this.movementFinderService = movementFinderService;
        this.movementMapper = movementMapper;
    }


    @GetMapping("/{id}") //Se usara todo despues de la barra como paramatero para el ID
    public ResponseEntity<MovementResponse> find(@PathVariable Long id){ //Devolvemos un ResponseEntity
        Movement movement = movementFinderService.find(id); //Guardamos la entidad que nos devulve el service con ese id
        MovementResponse response = movementMapper.convertor(movement);//Creamos una nueva entidad guardando los atributos que necesitamos, e ignorando los que no
        return ResponseEntity.ok(response); //Devolvemos el ResponseEntity con OK
    }

}
