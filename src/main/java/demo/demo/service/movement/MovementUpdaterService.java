package demo.demo.service.movement;


import demo.demo.model.movement.Movement;
import demo.demo.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementUpdaterService {

    private final JpaMovementRepository jpaMovementRepository;
    private final MovementFinderService movementFinderService;

    public MovementUpdaterService(JpaMovementRepository jpaMovementRepository, MovementFinderService movementFinderService){
        this.jpaMovementRepository = jpaMovementRepository;
        this.movementFinderService = movementFinderService;
    }

    //Servicio
    public Movement update(Long id, String name, String description){
        Movement movement = movementFinderService.find(id);
        movement.setName(name);
        movement.setDescription(description);
        return jpaMovementRepository.save(movement);
    }
}
