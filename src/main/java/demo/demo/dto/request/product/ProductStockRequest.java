package demo.demo.dto.request.product;

public class ProductStockRequest {
    private Integer stock;

    public ProductStockRequest(){};
    public ProductStockRequest(Integer stock){this.stock = stock;}

    //Getters
    public Integer getStock(){
        return stock;
    }
}
