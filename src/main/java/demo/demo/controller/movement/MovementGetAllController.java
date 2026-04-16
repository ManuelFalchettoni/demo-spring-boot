package demo.demo.controller.movement;


import demo.demo.dto.response.movement.MovementResponse;
import demo.demo.mapper.movement.MovementMapper;
import demo.demo.model.movement.Movement;
import demo.demo.service.movement.MovementFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class MovementGetAllController {

    private final MovementFinderService movementFinderService;
    private final MovementMapper movementMapper;

    public MovementGetAllController(MovementFinderService movementFinderService, MovementMapper movementMapper){
        this.movementFinderService = movementFinderService;
        this.movementMapper = movementMapper;
    }

    @GetMapping
    public ResponseEntity<List<MovementResponse>> finds(){
        List<Movement> movements = movementFinderService.finds();
        List<MovementResponse> responses = movements.stream()
                .map(m -> movementMapper.convertor(m))// .map(movementMapper::convertor) "method reference"
                .toList();
        return ResponseEntity.ok(responses);
    }
}
