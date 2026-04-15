package demo.demo.repository.movement;

import demo.demo.model.movement.Movement;//Agrego el ( .Movement )
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementRepository extends JpaRepository<Movement, Long>, JpaSpecificationExecutor<Movement> { //Para SpringBoot no puede ser una clase porque eso lo hace el ORM

}
