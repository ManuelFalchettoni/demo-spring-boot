package demo.demo.controller.product;

import demo.demo.dto.request.product.ProductRequest;
import demo.demo.dto.request.product.ProductStockRequest;
import demo.demo.dto.response.product.ProductResponse;
import demo.demo.service.product.ProductUpdateStockService;
import demo.demo.service.product.ProductUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products/stock")
public class ProductStockPutController {
    private final ProductUpdateStockService productUpdateStockService;

    public ProductStockPutController (ProductUpdateStockService productUpdateStockService){
        this.productUpdateStockService = productUpdateStockService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@RequestBody ProductStockRequest request, @PathVariable Long id){
        ProductResponse response = productUpdateStockService.updateStock(request, id);
        return ResponseEntity.ok(response);
    }
}
