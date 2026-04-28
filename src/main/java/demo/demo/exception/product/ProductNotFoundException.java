package demo.demo.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //Response con el tipo de respuesta
public class ProductNotFoundException extends RuntimeException{ //Extender des las exceptions de Java

    //Metodo MAGICO constructor
    public ProductNotFoundException(Long id){
        super("Product not found " + id);
    }
}