package com.langfordfam.contactmgr;

public class NoSuchContactException extends RuntimeException {
    public NoSuchContactException(Long id) {
        super("Could not find a Contact with id = " + id);
    }
}
