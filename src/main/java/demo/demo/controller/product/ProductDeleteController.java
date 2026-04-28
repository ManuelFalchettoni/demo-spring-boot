package demo.demo.controller.product;

import demo.demo.service.product.ProductDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductDeleteController {
    private final ProductDeleteService productDeleteService;

    public ProductDeleteController(ProductDeleteService productDeleteService){
        this.productDeleteService = productDeleteService;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productDeleteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
