package com.langfordfam.contactmgr;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Persistable object representing a name.
 */
@Embeddable
public class Name {
    private String first;
    private String middle;
    private String last;

    public Name() {
    }

    public Name(String firstName, String middleName, String lastName) {
        first = firstName;
        middle = middleName;
        last = lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", middle='" + middle + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(first, name.first) &&
                Objects.equals(middle, name.middle) &&
                Objects.equals(last, name.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, middle, last);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
