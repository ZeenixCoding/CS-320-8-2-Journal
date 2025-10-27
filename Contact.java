package contactService;

// basic contact class that holds info for each person
public class Contact {
    private final String contactId; // id stays fixed once set
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // constructor that validates every field on creation
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // making sure the ID isn't null or longer than 10 chars
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");
        // first and last names both required and limited to 10 chars
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        // phone has to be exactly 10 digits
        if (phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        // address required, max 30 chars
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // getters for all fields
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // setters that apply the same validation rules
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}
