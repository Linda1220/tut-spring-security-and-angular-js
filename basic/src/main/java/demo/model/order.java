package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 25/02/16.
 */
@Entity
@Table(name = "orders")
public class Order {
    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    // User who made the order
    @NotNull
    private long userId;

    // The order's address
    @NotNull
    private long addressId;

    //The product id in the order
    @NotNull
    private long productId;

    //The product quantity
    @NotNull
    private int quantity;

    //The product price
    @NotNull
    private String price;

    //The product status
    @NotNull
    private String status;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------
    public Order() {}

    public Order(long id) {
        this.id = id;
    }

    public Order(long userId, long addressId, long productId, int quantity, String price, String status) {
        this.userId = userId;
        this.addressId = addressId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public Order(OrderDTO orderDTO ){this(orderDTO.getUserId(),orderDTO.getAddressId(),orderDTO.getProductId(),orderDTO.getQuantity(),orderDTO.getPrice(),orderDTO.getStatus());}
// Getter and setter methods


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

