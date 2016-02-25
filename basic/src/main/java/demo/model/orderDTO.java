package demo.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 25/02/16.
 */
public class OrderDTO {
    private long id = 0;
    private long addressId;
    private long userId;
    private long productId;
    private int quantity;
    private String price;
    private String status;

    public OrderDTO() {}

    public OrderDTO(long addressId, long userId, long productId, int quantity, String price, String status) {
        this.addressId = addressId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
