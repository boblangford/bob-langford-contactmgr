package com.langfordfam.contactmgr;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Implements a REST API for managing personal contact information.
 */
@RestController
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
    private final ContactStore database;

    public ContactController(ContactStore database) {
        this.database = database;
    }

    @GetMapping("/contacts")    // FIXME should return List of all contacts
    public List<Contact> listAll() {
        log.info("Client requested list of all contacts.");
        List<Contact> contacts = database.findAll();
        log.info("    " + contacts.size() + " contacts found.");
        return contacts;
    }

    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact newContact) {
        log.info("Client created a new contact.");
        return database.save(newContact);
    }  // TODO implement this

    @PutMapping("/contacts/{id}")
    public Contact updateContact(@RequestBody Contact updatedContact, @PathVariable Long id) {
        log.info("Client updated an existing contact, with ID = " + id);
        return null;
    }  // TODO implement this

    /**
     * Allows the client to retrieve a single, specific contact by giving the ID number.
     * @param id the ID number of the contact
     * @return the Contact with that ID
     * @throws NoSuchContactException if there is no Contact with that ID number
     */
    @GetMapping("/contacts/{id}")
    public Contact readContact(@PathVariable Long id) {
        log.info("Client requested contact with ID = " + id);
        Optional<Contact> result = database.findById(id);
        if ( ! result.isPresent()) {
            log.warn("---> No such contact was found.");
            throw new NoSuchContactException(id);
        }
        return result.get();
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        log.info("Client requested to delete contact with ID = " + id);
    }  // TODO implement this


}
