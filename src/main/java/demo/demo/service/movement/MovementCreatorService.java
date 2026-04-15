package demo.demo.service.movement;


import demo.demo.model.movement.Movement;
import demo.demo.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

@Service //Anotacion
public class MovementCreatorService {
    //Instanciar repository
    private final JpaMovementRepository jpaMovementRepository;

    //Constructor
    public MovementCreatorService(JpaMovementRepository jpaMovementRepository){
        this.jpaMovementRepository = jpaMovementRepository;
    }
    //El servicio
    public Movement create(Movement movement){ //Paso nu movement pero tambein me devuelve otro movement
        return jpaMovementRepository.save(movement);
    } //Usamos una de las funciones dentro de JPA
}
