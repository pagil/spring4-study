package demo.orika.test.domain;

import com.google.common.base.MoreObjects;

public class Address {
    private String street;
    private String city;
    private String zipCode;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("street", this.getStreet())
                .add("city", this.getCity())
                .add("zipCode", this.getZipCode())
                .toString();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
