package demo.demo.service.product;

import demo.demo.dto.request.product.ProductRequest;
import demo.demo.dto.response.product.ProductResponse;
import demo.demo.mapper.product.ProductMapper;
import demo.demo.model.product.Product;
import demo.demo.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdaterService {
    private final JpaProductRepository jpaProductRepository;
    private final ProductFinderService productFinderService;

    public ProductUpdaterService(JpaProductRepository jpaProductRepository, ProductFinderService productFinderService){
        this.jpaProductRepository = jpaProductRepository;
        this.productFinderService = productFinderService;
    }

    public ProductResponse update(ProductRequest request, Long id){
        Product product = productFinderService.find(id);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setActive(request.getActive());
        product.setStock(request.getStock());
        Product saved = jpaProductRepository.save(product);
        return ProductMapper.productToResponse(saved);
    }
}
