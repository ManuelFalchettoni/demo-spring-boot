package demo.demo.mapper.product;

import demo.demo.dto.request.product.ProductRequest;
import demo.demo.dto.response.product.ProductResponse;
import demo.demo.model.product.Product;

public class ProductMapper {

    public static Product requestToProduct(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setActive(request.getActive());
        product.setStock(request.getStock());
        return product;
    }

    public static ProductResponse productToResponse(Product product){
        ProductResponse response = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getActive(),
                product.getStock()
        );
        return response;
    }
}
