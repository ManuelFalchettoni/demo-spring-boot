package demo.demo.controller.movement;

import demo.demo.dto.request.movement.MovementRequest;
import demo.demo.dto.response.movement.MovementResponse;
import demo.demo.mapper.movement.MovementMapper;
import demo.demo.model.movement.Movement;
import demo.demo.service.movement.MovementUpdaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movements")
public class MovementPutController {
    //Instanciar
    private final MovementUpdaterService movementUpdaterService;

    //Inicializar
    public MovementPutController (MovementUpdaterService movementUpdaterService){
        this.movementUpdaterService = movementUpdaterService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementResponse> update(@RequestBody MovementRequest movementRequest, @PathVariable Long id){
        Movement movement = movementUpdaterService.update(id, movementRequest.getName(), movementRequest.getDescription());
        MovementResponse response = MovementMapper.convertor(movement);
        return ResponseEntity.ok(response);
    }
}
