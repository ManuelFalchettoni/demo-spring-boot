package demo.demo.controller.product;

import demo.demo.dto.request.product.ProductRequest;
import demo.demo.dto.response.product.ProductResponse;
import demo.demo.service.product.ProductCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductPostController {
    private final ProductCreatorService productCreatorService;

    public ProductPostController (ProductCreatorService productCreatorService) {
        this.productCreatorService = productCreatorService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
        ProductResponse response = productCreatorService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
