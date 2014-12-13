package demo.orika.test.domain;


import com.google.common.base.MoreObjects;

import java.util.List;

public class Person {
    private Long id;
    private String name;
    private List<String> surnames;
    private Address address;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.getId())
                .add("name", this.getName())
                .add("surnames", this.getSurnames())
                .add("address", this.getAddress())
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSurnames() {
        return surnames;
    }

    public void setSurnames(List<String> surnames) {
        this.surnames = surnames;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
