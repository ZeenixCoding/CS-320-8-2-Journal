package contactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// tests that the ContactService logic works as expected
class ContactServiceTest {

    @Test
    void addContact_unique_success() {
        ContactService s = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "Addr");
        s.addContact(c);
        // verifying it actually stored the contact
        assertEquals("John", s.getContact("1").getFirstName());
    }

    @Test
    void addContact_duplicateId_throws() {
        ContactService s = new ContactService();
        s.addContact(new Contact("1", "A", "B", "1234567890", "Addr"));
        // adding same ID again should throw
        assertThrows(IllegalArgumentException.class,
            () -> s.addContact(new Contact("1", "C", "D", "0987654321", "Addr2")));
    }

    @Test
    void deleteContact_valid_removes() {
        ContactService s = new ContactService();
        s.addContact(new Contact("1", "A", "B", "1234567890", "Addr"));
        s.deleteContact("1");
        assertThrows(IllegalArgumentException.class, () -> s.getContact("1"));
    }

    @Test
    void updateContactFields_success() {
        ContactService s = new ContactService();
        s.addContact(new Contact("1", "John", "Doe", "1234567890", "Addr"));
        s.updateFirstName("1", "Jane");
        s.updatePhone("1", "0987654321");
        assertEquals("Jane", s.getContact("1").getFirstName());
        assertEquals("0987654321", s.getContact("1").getPhone());
    }

    @Test
    void updatePhone_invalid_throws() {
        ContactService s = new ContactService();
        s.addContact(new Contact("1", "A", "B", "1234567890", "Addr"));
        // invalid number should throw
        assertThrows(IllegalArgumentException.class, () -> s.updatePhone("1", "22"));
    }
}

