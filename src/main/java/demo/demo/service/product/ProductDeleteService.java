package demo.demo.service.product;

import demo.demo.model.product.Product;
import demo.demo.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleteService {
    private final JpaProductRepository jpaProductRepository;

    public ProductDeleteService(JpaProductRepository jpaProductRepository){
        this.jpaProductRepository = jpaProductRepository;

    }

    public void delete(Long id){
        jpaProductRepository.deleteById(id);
    }
}
