//to store 10 contact list and throiw exception if the contact already exists and also provide options to add contact edit contact and search contact.
import java.util.*;

class ContactAlreadyExistsException extends Exception {
    public ContactAlreadyExistsException(String message) {
        super(message);
    }
}
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
public class ContactManager {
    static HashMap<String, String> contacts = new HashMap<>();
    public static void validatePhone(String phone)
            throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                    "Phone number must be exactly 10 digits.");
        }
    }
    public static void addContact(String name, String phone)
            throws ContactAlreadyExistsException, InvalidPhoneNumberException {

        if (contacts.size() >= 10) {
            System.out.println("Contact list is full (Max 10 allowed).");
            return;
        }
        validatePhone(phone);

        if (contacts.containsKey(phone)) {
            throw new ContactAlreadyExistsException(
                    "Contact number already exists!");
        }
        contacts.put(phone, name);
        System.out.println("Contact added successfully.");
    }
    public static void searchContact(String phone)
            throws InvalidPhoneNumberException {

        validatePhone(phone);

        if (contacts.containsKey(phone)) {
            System.out.println("Contact Found:");
            System.out.println("Name: " + contacts.get(phone));
            System.out.println("Phone: " + phone);
        } else {
            System.out.println("Contact not found.");
        }
    }
    public static void editContact(String phone, String newName)
            throws InvalidPhoneNumberException {

        validatePhone(phone);

        if (contacts.containsKey(phone)) {
            contacts.put(phone, newName);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found. Cannot edit.");
        }
    }
    public static void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\nAll Contacts:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println("Name: " + entry.getValue() +
                        ", Phone: " + entry.getKey());
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. View All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Phone Number: ");
                        String phone = sc.nextLine();

                        addContact(name, phone);
                        break;

                    case 2:
                        System.out.print("Enter Phone Number to Search: ");
                        searchContact(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter Phone Number to Edit: ");
                        String editPhone = sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        editContact(editPhone, newName);
                        break;

                    case 4:
                        displayAll();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (ContactAlreadyExistsException |
                     InvalidPhoneNumberException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
