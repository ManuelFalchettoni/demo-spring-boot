package demo.demo.service.product;

import demo.demo.dto.request.product.ProductStockRequest;
import demo.demo.dto.response.product.ProductResponse;
import demo.demo.mapper.product.ProductMapper;
import demo.demo.model.product.Product;
import demo.demo.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdateStockService {
    private JpaProductRepository jpaProductRepository;
    private ProductFinderService productFinderService;

    public ProductUpdateStockService(JpaProductRepository jpaProductRepository, ProductFinderService productFinderService){
        this.jpaProductRepository = jpaProductRepository;
        this.productFinderService = productFinderService;
    }

    public ProductResponse updateStock(ProductStockRequest request, Long id){
        Product product = productFinderService.find(id);
        product.setStock(request.getStock());
        Product save = jpaProductRepository.save(product);
        return ProductMapper.productToResponse(save);
    }
}
