package demo.demo.service.movement;


import demo.demo.dto.request.movement.MovementRequest;
import demo.demo.mapper.movement.MovementMapper;
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
    public Movement create(MovementRequest movementRequest){
        Movement movement = MovementMapper.toEntity(movementRequest);
        return jpaMovementRepository.save(movement);
    } //Usamos una de las funciones dentro de JPA
}
