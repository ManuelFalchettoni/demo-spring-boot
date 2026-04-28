package demo.demo.dto.request.product;

public class ProductRequest {

    private String name;
    private String description;
    private Float price;
    private Boolean active;
    private Integer stock;

    public ProductRequest(){}
    public ProductRequest(String name, String description, Float price, Boolean active,Integer stock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.stock = stock;
    }

    //Getters

    public String getName() {return name;}
    public String getDescription() {return description;}
    public Float getPrice() {return price;}
    public Boolean getActive() {return active;}
    public Integer getStock() {return stock;}
}
