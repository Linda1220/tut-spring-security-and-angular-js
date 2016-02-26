package demo.model;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 26/02/16.
 */
@Entity
@Table(name = "orderdetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //The product id in the order
    @ManyToOne
    private Product product;

    //The order id
    @ManyToOne
    private Order order;

    @NotNull
    private int quality;

    @NotNull
    private String price;

    public OrderDetail(){}

    public OrderDetail(long id) {
        this.id = id;
    }

    public OrderDetail(Product product, Order order, int quality, String price) {
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
