package demo.demo.controller.product;

import demo.demo.dto.request.product.ProductRequest;
import demo.demo.dto.response.product.ProductResponse;
import demo.demo.service.product.ProductUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductPutController {
    private final ProductUpdaterService productUpdaterService;

    public ProductPutController (ProductUpdaterService productUpdaterService){
        this.productUpdaterService = productUpdaterService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@RequestBody ProductRequest request, @PathVariable Long id){
        ProductResponse response = productUpdaterService.update(request, id);
        return ResponseEntity.ok(response);
    }
}
