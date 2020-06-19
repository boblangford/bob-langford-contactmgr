package com.langfordfam.contactmgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads one contact into the database as a sample entry.
 */
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ContactStore repository) {

        return args -> {
            Contact c = new Contact();
            Phone p;
            c.setName(new Name("Charlie", "C", "Calhoun"));
            c.setAddress(new Address("333 Canal Ct", "Chelsea", "CA", "98765"));
            c.setEmail("c.c.calhoun@example.com");
            List<Phone> phones = new ArrayList<>();
            p = new Phone("213-456-7890", "home");
            phones.add(p);
            p = new Phone("213-987-6541", "mobile");
            phones.add(p);
            c.setPhone(phones);
            log.info("Preloading " + repository.save(c));
        };
    }
}
