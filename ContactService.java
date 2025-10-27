package contactService;

import java.util.HashMap;
import java.util.Map;

// handles adding, updating, and deleting contacts from memory
public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    // adds a contact only if that ID isn't already taken
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Contact ID already exists");
        contacts.put(contact.getContactId(), contact);
    }

    // deletes contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new IllegalArgumentException("Contact not found");
        contacts.remove(contactId);
    }

    // simple update methods – reuses Contact's own setters for validation
    public void updateFirstName(String contactId, String newFirstName) {
        getContact(contactId).setFirstName(newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        getContact(contactId).setLastName(newLastName);
    }

    public void updatePhone(String contactId, String newPhone) {
        getContact(contactId).setPhone(newPhone);
    }

    public void updateAddress(String contactId, String newAddress) {
        getContact(contactId).setAddress(newAddress);
    }

    // helper to fetch contact safely (throws if not found)
    public Contact getContact(String contactId) {
        Contact c = contacts.get(contactId);
        if (c == null)
            throw new IllegalArgumentException("Contact not found");
        return c;
    }
}
