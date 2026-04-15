package demo.demo.service.movement;

import demo.demo.model.movement.Movement;
import demo.demo.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

@Service //Anotacion
public class MovementDeleterService {
    //Instanciar
    private final JpaMovementRepository jpaMovementRepository;
    private final MovementFinderService movementFinderService; //Para no repetir codigo usaremos el finder anterior

    //Constructor
    public MovementDeleterService(
            JpaMovementRepository jpaMovementRepository,
            MovementFinderService movementFinderService
    ) {
        this.jpaMovementRepository = jpaMovementRepository;
        this.movementFinderService = movementFinderService;

    }

    //Servicio (Void porque no devuelve nada)
    public void delete(Long id){
        Movement movement = movementFinderService.find(id); //Ya que ya tengo la entidad a traves de finder uso Delete en vez de DeleteById
        jpaMovementRepository.delete(movement); //Funcion dentro de JPA
    }

}
