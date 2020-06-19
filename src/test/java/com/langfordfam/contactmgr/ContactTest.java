package com.langfordfam.contactmgr;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.test.context.event.annotation.BeforeTestMethod;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
public class ContactTest {

    private static final Logger log = LoggerFactory.getLogger(ContactTest.class);
    Contact original, modification;

    @BeforeEach
    void setup() {
        original = new Contact(new Name("Bill", "Barney", "Brown"),
                new Address("222 Baker St", "Birmingham", "BC", "22202"),
                "bill.brown@example.com",
                new Phone("222-1111", "home"),
                new Phone("222-3333","work"));
        modification = new Contact(new Name("Gary", "Gustav", "Garmin"),
                new Address("7704 Grumpy St", "Gunderson", "GA", "77101"),
                "gg.garmin@example.com",
                new Phone("737-4663", "home"),
                new Phone("737-3675","work"));
    }

    @Test
    void equalTest() {
        assertEquals(original, original, "a Contact should be equal to itself");
    }

    @Test
    void unequalTest() {
        assertNotEquals(original, modification, "the two contacts should not be equal");
    }

    @Test
    void updateTest() {
        original.update(modification);
        assertEquals(original, modification, "original Contact should be equal to modified one");
    }

}
