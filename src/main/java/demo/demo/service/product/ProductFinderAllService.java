package demo.demo.service.product;

import demo.demo.exception.product.ProductNotFoundException;
import demo.demo.model.product.Product;
import demo.demo.repository.product.JpaProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductFinderAllService {
    private final JpaProductRepository jpaProductRepository;

    public ProductFinderAllService (JpaProductRepository jpaProductRepository){
        this.jpaProductRepository = jpaProductRepository;
    }

    public Page<Product> findAll(Pageable pageable){
        return jpaProductRepository.findAll(pageable);
    }
}
