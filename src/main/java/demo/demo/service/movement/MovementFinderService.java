package demo.demo.service.movement;

import demo.demo.exception.movement.MovementNotFoundException;
import demo.demo.model.movement.Movement;
import demo.demo.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Anotacion
public class MovementFinderService {
    //Inicializar e Instanciar
    //Instancia declaro propiedad (atributo)
    //Inicializaion que valor va a tener mi atributo

    private final JpaMovementRepository jpaMovementRepository;//Final --> mi clase no puede ser extendida en otra clase

    //Metodo MAGICO constructor (Se ejecuta en un evento)
    public MovementFinderService(JpaMovementRepository jpaMovementRepository){
        this.jpaMovementRepository = jpaMovementRepository; //Inicializar
    }

    //Servicio (Desde el servicio siempre pasamos la entidad al controller)
    //Lambda es una funcion sin nombre ni cuerpo [ () -> ]
    public Movement find(Long id){
        //[Funcion Lambda () -> ]
        return jpaMovementRepository.findById(id)
                .orElseThrow( () -> new MovementNotFoundException(id)); //Lambda
    }

    public  List<Movement>  finds(){
        return jpaMovementRepository.findAll();
    }
}
