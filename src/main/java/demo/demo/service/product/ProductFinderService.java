package demo.demo.service.product;

import demo.demo.exception.movement.MovementNotFoundException;
import demo.demo.exception.product.ProductNotFoundException;
import demo.demo.model.product.Product;
import demo.demo.repository.product.JpaProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductFinderService {
    private final JpaProductRepository jpaProductRepository;

    public ProductFinderService (JpaProductRepository jpaProductRepository){
        this.jpaProductRepository = jpaProductRepository;
    }

    public Product find(Long id){
        return jpaProductRepository.findById(id)
                .orElseThrow( () -> new ProductNotFoundException(id));
    }

}
