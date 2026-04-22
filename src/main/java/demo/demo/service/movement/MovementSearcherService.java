package demo.demo.service.movement;

import demo.demo.model.movement.Movement;
import demo.demo.repository.movement.JpaMovementRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovementSearcherService {
    private final JpaMovementRepository jpaMovementRepository;

    public MovementSearcherService(JpaMovementRepository jpaMovementRepository){
        this.jpaMovementRepository = jpaMovementRepository;
    }

    public Page<Movement> findAll(Pageable pageable){
        return jpaMovementRepository.findAll(pageable);
    }
}
