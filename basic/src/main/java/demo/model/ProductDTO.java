package demo.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 23/02/16.
 */
public class ProductDTO {
    private long id;
    private String brand;
    private String name;
    private String price1;
    private String price2;
    private String price3;
    private String version;
    private String weight;
    private String provider1;
    private String provider2;
    private String provider3;

    public ProductDTO(){}

    public ProductDTO(String brand, String name, String price1, String price2, String price3, String version, String weight, String provider1, String provider2, String provider3) {
        this.brand = brand;
        this.name = name;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.version = version;
        this.weight = weight;
        this.provider1 = provider1;
        this.provider2 = provider2;
        this.provider3 = provider3;
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

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
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

    public String getProvider1() {
        return provider1;
    }

    public void setProvider1(String provider1) {
        this.provider1 = provider1;
    }

    public String getProvider2() {
        return provider2;
    }

    public void setProvider2(String provider2) {
        this.provider2 = provider2;
    }

    public String getProvider3() {
        return provider3;
    }

    public void setProvider3(String provider3) {
        this.provider3 = provider3;
    }
}
