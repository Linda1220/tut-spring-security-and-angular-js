package demo.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Linda on 25/02/16.
 */
public class AddressDTO {
    private long id = 0;
    private long userId;
    private String name;
    private String address;
    private String province;
    private String country;
    private String postcode;
    private String phone;

    public AddressDTO(){}

    public AddressDTO(long userId, String name, String address, String province, String country, String postcode, String phone) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.province = province;
        this.country = country;
        this.postcode = postcode;
        this.phone = phone;
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
