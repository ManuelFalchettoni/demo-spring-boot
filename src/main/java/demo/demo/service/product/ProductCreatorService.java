package demo.demo.service.product;


import demo.demo.dto.request.product.ProductRequest;
import demo.demo.dto.response.product.ProductResponse;
import demo.demo.mapper.product.ProductMapper;
import demo.demo.model.product.Product;
import demo.demo.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreatorService {
    private final JpaProductRepository jpaProductRepository;

    public ProductCreatorService (JpaProductRepository jpaProductRepository){
        this.jpaProductRepository = jpaProductRepository;
    }

    public ProductResponse create(ProductRequest request){
        Product product = ProductMapper.requestToProduct(request);
        Product saved = jpaProductRepository.save(product);
        return ProductMapper.productToResponse(saved);
    }
}
