package com.langfordfam.contactmgr;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Persistable object representing a phone number.
 */
@Embeddable
public class Phone {

    private String number;
    private String type;

    public Phone() {
    }

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return number.equals(phone.number) &&
                type.equals(phone.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
