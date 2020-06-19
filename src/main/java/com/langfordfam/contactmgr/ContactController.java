package com.langfordfam.contactmgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Implements a REST API for managing personal contact information.
 */
@RestController
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactStore database;

    public ContactController(ContactStore database) {
        this.database = database;
    }

    /**
     * Allows the client to retrieve all Contacts in the system.
     *
     * @return a List of Contacts, in no particular order
     */
    @GetMapping("/contacts")
    public List<Contact> listAll() {
        log.info("Client requested list of all contacts.");
        List<Contact> contacts = database.findAll();
        log.info("    " + contacts.size() + " contacts found.");
        return contacts;
    }

    /**
     * Allows the client to create a new Contact.  The body of the request must be
     * the data for the new Contact in JSON form.  An ID number will be assigned automatically.
     *
     * @param newContact the new contact to be added.
     * @return the newly-created Contact
     */
    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact newContact) {
        log.info("Client created a new contact.");
        return database.save(newContact);
    }

    /**
     * Allows the client to update an existing Contact.
     * @param updatedContact The new information for the Contact
     * @param id the ID number of the Contact to be updated
     * @return the newly updated Contact
     */
    @PutMapping("/contacts/{id}")
    public Contact updateContact(@RequestBody Contact updatedContact, @PathVariable Long id) {
        log.info("Client updated an existing contact, with ID = " + id);
        Optional<Contact> result = database.findById(id);
        if (!result.isPresent()) {
            log.warn("---> No such contact was found.");
            throw new NoSuchContactException(id);
        }
        Contact existingContact = result.get();
        existingContact.update(updatedContact);
        database.save(existingContact);
        return null;
    }

    /**
     * Allows the client to retrieve a single, specific contact by giving the ID number.
     *
     * @param id the ID number of the contact
     * @return the Contact with that ID
     * @throws NoSuchContactException if there is no Contact with that ID number
     */
    @GetMapping("/contacts/{id}")
    public Contact readContact(@PathVariable Long id) {
        log.info("Client requested contact with ID = " + id);
        Optional<Contact> result = database.findById(id);
        if (!result.isPresent()) {
            log.warn("---> No such contact was found.");
            throw new NoSuchContactException(id);
        }
        return result.get();
    }

    /**
     * Allows the client to delete a specified Contact by giving the ID number.
     * @param id the ID number of the Contact to be deleted
     */
    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        log.info("Client requested to delete contact with ID = " + id);
        database.deleteById(id);
    }


}
