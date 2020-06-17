package com.langfordfam.contactmgr;

import javax.persistence.*;
import java.util.List;

/**
 * Persistable object that represents a Contact.
 */
@Entity
public class Contact {

    private @Id
    @GeneratedValue
    Long id;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @ElementCollection
    private List<Phone> phone;

    private String email;

    public Contact() {
    }

    /**
     * Update all data fields of this Contact with data from another Contact.
     * @param n The Contact that is the source of the new data
     */
    public void update(Contact n) {
        name = n.getName();
        address = n.getAddress();
        phone = n.getPhone();
        email = n.getEmail();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

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
