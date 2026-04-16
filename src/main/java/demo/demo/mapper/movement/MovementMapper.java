package demo.demo.mapper.movement;

import demo.demo.dto.request.movement.MovementRequest;
import demo.demo.dto.response.movement.MovementResponse;
import demo.demo.model.movement.Movement;
import org.springframework.stereotype.Component;


@Component
public class MovementMapper {

    public MovementResponse convertor(Movement movement){
        return new MovementResponse (movement.getId(), movement.getName(), movement.getDescription());
    }

    public Movement toEntity(MovementRequest movementRequest){
        Movement movement = new Movement();
        movement.setName(movementRequest.getName());
        movement.setDescription(movementRequest.getDescription());
        return movement;
    }
}
