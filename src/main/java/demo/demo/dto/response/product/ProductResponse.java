package demo.demo.dto.response.product;

public class ProductResponse {
    //Instanciar
    private Long id;
    private String name;
    private String description;
    private Float price;
    private Boolean active;
    private Integer stock;

    //Los DTOs por defecto tienen dos constructores
    public ProductResponse() {};
    public ProductResponse(Long id, String name, String description,Float price, Boolean active, Integer stock){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.stock = stock;
    }

    //Getters y setters
    public Long getId() {return id;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public Float getPrice() {return price;}
    public Boolean getActive() {return active;}
    public Integer getStock() {return stock;}

    public void setId(Long id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setPrice(Float price) {this.price = price;}
    public void setActive(Boolean active) {this.active = active;}
    public void setStock(Integer stock) {this.stock = stock;}
}
