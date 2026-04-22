package demo.demo.controller.movement;


import demo.demo.dto.response.movement.MovementResponse;
import demo.demo.mapper.movement.MovementMapper;
import demo.demo.model.movement.Movement;
import demo.demo.service.movement.MovementFinderService;
import demo.demo.service.movement.MovementSearcherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class MovementGetAllController {

    private final MovementSearcherService movementSearcherService;

    public MovementGetAllController(MovementSearcherService movementSearcherService){
        this.movementSearcherService = movementSearcherService;
    }

    @GetMapping
    //movements?page=2&size=5
    public ResponseEntity<Page<MovementResponse>> finds(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        Page<Movement> movements = movementSearcherService.findAll(pageable);

        return ResponseEntity.ok(
                movements.map(MovementMapper::convertor)
        );



    }






    /*private final MovementFinderService movementFinderService;
    private final MovementMapper movementMapper;

    public MovementGetAllController(MovementFinderService movementFinderService, MovementMapper movementMapper){
        this.movementFinderService = movementFinderService;
        this.movementMapper = movementMapper;
    }

    @GetMapping
    public ResponseEntity<List<MovementResponse>> finds(){
        List<Movement> movements = movementFinderService.finds();

        return ResponseEntity.ok(movementMapper.toResponseList(movements));
    }*/
}
