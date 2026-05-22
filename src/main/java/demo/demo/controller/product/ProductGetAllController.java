package demo.demo.controller.product;

import demo.demo.dto.response.product.ProductResponse;
import demo.demo.mapper.product.ProductMapper;
import demo.demo.model.product.Product;
import demo.demo.service.product.ProductFinderAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductGetAllController {
    private final ProductFinderAllService productFinderAllService;

    public ProductGetAllController(ProductFinderAllService productFinderAllService){
        this.productFinderAllService = productFinderAllService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productFinderAllService.findAll(pageable);

        return ResponseEntity.ok(
                products.map(ProductMapper::productToResponse) // p -> ProductMapper.convertor(p)
        );
    }
}
