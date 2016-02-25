package demo.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 23/02/16.
 */
public class ProductDTO {
    private long id;
    private String brand;
    private String name;
    private String price;
    private String oldprice;
    private String instruction;
    private String version;
    private String weight;
    private String provider;
    private String picturelink;
    private int quantity;

    public ProductDTO(){}

    public ProductDTO(String brand, String name, String price, String oldprice, String instruction, String version, String weight, String provider, String picturelink, int quantity) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.oldprice = oldprice;
        this.instruction = instruction;
        this.version = version;
        this.weight = weight;
        this.provider = provider;
        this.picturelink = picturelink;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPicturelink() {
        return picturelink;
    }

    public void setPicturelink(String picturelink) {
        this.picturelink = picturelink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
