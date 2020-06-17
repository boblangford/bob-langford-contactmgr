package com.langfordfam.contactmgr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    private @Id
    @GeneratedValue Long id;
    @Embedded
    private Name name;
    @Embedded
    private Address address;
    @OneToMany
    private List<Phone> phone;
    private String email;

    public Contact() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
