package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linda on 25/02/16.
 */
@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    // User who have the addreee
    @OneToOne
    private User user;

    //The addreess user name
    @NotNull
    private String name;

    //The address
    @NotNull
    private String address;

    //The province
    private String province;

    //The country
    private String country;

    //The post code
    private String postcode;

    //The phone number
    @NotNull
    private String phone;

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Order> orders = new ArrayList<>();


    public Address(){}
    public Address(long id) {
        this.id = id;
    }

    public Address(User user, String name, String address, String province, String country, String postcode, String phone, List<Order> orders) {
        this.user = user;
        this.name = name;
        this.address = address;
        this.province = province;
        this.country = country;
        this.postcode = postcode;
        this.phone = phone;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
