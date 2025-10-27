package contactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// tests for the Contact object itself
class ContactTest {

    @Test
    void createValidContact_success() {
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", c.getFirstName());
    }

    @Test
    void id_mustBeNonNull_andMax10() {
        // should throw since ID is null or too long
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "A", "B", "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "A", "B", "1234567890", "Addr"));
    }

    @Test
    void phone_mustBeExactly10Digits() {
        // invalid phone format
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "A", "B", "123", "Addr"));
    }

    @Test
    void setters_enforceRules() {
        Contact c = new Contact("1", "A", "B", "1234567890", "Addr");
        // too long of a name or invalid phone should trigger exceptions
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ABCDEFGHIJK"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("999"));
    }
}

