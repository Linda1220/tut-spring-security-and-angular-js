package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 25/02/16.
 */
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    // User who have the addreee
    @NotNull
    private long userId;

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

    public Address(){}
    public Address(long id) {
        this.id = id;
    }

    public Address(long userId, String name, String address, String province, String country, String postcode, String phone) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.province = province;
        this.country = country;
        this.postcode = postcode;
        this.phone = phone;
    }
    public Address(AddressDTO addressDTO){
        this(addressDTO.getUserId(),addressDTO.getName(),addressDTO.getAddress(),addressDTO.getProvince(),addressDTO.getCountry(),addressDTO.getPostcode(),addressDTO.getPhone());
    }

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
}
