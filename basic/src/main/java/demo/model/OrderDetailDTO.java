package demo.model;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 26/02/16.
 */
public class OrderDetailDTO {
    private long id;
    private Product product;
    private Order order;
    private int quality;
    private String price;

    public OrderDetailDTO(long id) {
        this.id = id;
    }

    public OrderDetailDTO(Product product, Order order, int quality, String price) {
        this.product = product;
        this.order = order;
        this.quality = quality;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
