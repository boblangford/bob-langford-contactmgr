package com.langfordfam.contactmgr;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Name {
    private String first;
    private String middle;
    private String last;

    public Name() {}

    public Name(String firstName, String middleName, String lastName) {
        first = firstName;
        middle = middleName;
        last = lastName;
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
