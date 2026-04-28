package demo.demo.controller.product;

import demo.demo.dto.response.product.ProductResponse;
import demo.demo.mapper.product.ProductMapper;
import demo.demo.model.product.Product;
import demo.demo.service.product.ProductFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductGetController {
    private final ProductFinderService productFinderService;

    public ProductGetController(ProductFinderService productFinderService) {
        this.productFinderService = productFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id){
        Product product = productFinderService.find(id);
        ProductResponse response = ProductMapper.productToResponse(product);
        return ResponseEntity.ok(response);

    }
}
