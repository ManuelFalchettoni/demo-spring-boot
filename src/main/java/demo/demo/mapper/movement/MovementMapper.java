package demo.demo.mapper.movement;

import demo.demo.dto.request.movement.MovementRequest;
import demo.demo.dto.response.movement.MovementResponse;
import demo.demo.model.movement.Movement;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MovementMapper {

    public static MovementResponse convertor(Movement movement){
        return new MovementResponse (movement.getId(), movement.getName(), movement.getDescription());
    }

    public static Movement toEntity(MovementRequest movementRequest){
        Movement movement = new Movement();
        movement.setName(movementRequest.getName());
        movement.setDescription(movementRequest.getDescription());
        return movement;
    }
    public static List<MovementResponse> toResponseList(List<Movement> movements){
        return movements.stream()
                .map(MovementMapper::convertor)
                .toList();
    }
}
