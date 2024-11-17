package contact_manager;

import java.util.Scanner;

public class ContactManager {
    Contact[] contacts = new Contact[10];
    int index = 0;

    public void start() {
        boolean b = true;

        while (b) {
            Menu();
            int n = getMenuNumber();

            switch (n) {
                case 1 -> {
                    Contact contact = getContact();
                    addArray(contact);
                }
                case 2 -> printContactList();
                case 3 -> {
                    String query = getQuery();
                    search(query);
                }
                case 4 -> {
                    String phone = deleteContact();
                    deleteContactFromArray(phone);
                }
                case 0 -> b = false;

                default -> System.out.println("Choose current number please: ");
            }
        }

        System.out.println("System end");
    }

    public void Menu() {
        System.out.println("**** Menu ****");
        System.out.println("1 - Add Contact");
        System.out.println("2 - Contact List");
        System.out.println("3 - Search");
        System.out.println("4 - Delete contact");
        System.out.println("0 - Exit");
    }

    public int getMenuNumber() {
        System.out.print("Choose menu: ");

        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public Contact getContact() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter surname: ");
        String surname = in.nextLine();

        System.out.print("Enter name: ");
        String name = in.nextLine();

        System.out.print("Enter phone number: ");
        String phone = in.next();

        Contact contact = new Contact(surname, name, phone);
        contact.surname = surname;
        contact.name = name;
        contact.phone = phone;

        // return new Contact(surname, name, phone);

        return contact;
    }

    public boolean isValidContact(Contact contact) {
        if (contact.surname == null || contact.surname.trim().length() < 5) {
            System.out.println("Surname must be at least 5 characters long!");
            return false;
        }
        if (contact.name == null || contact.name.trim().length() < 3) {
            System.out.println("Name must be at least 3 characters long!");
            return false;
        }
        if (contact.phone == null || contact.phone.trim().length() != 9) {
            System.out.println("Phone number must be at least 9 letters long!");
            return false;
        }
        char[] phoneChar = contact.phone.toCharArray();

        for (char c : phoneChar) {
            if (!Character.isDigit(c)) {
                System.out.println("Phone number must be at least 9 letters long!");
                return false;
            }
        }
        return true;
    }

    public void addArray(Contact contact) {
        if (!isValidContact(contact)) {
            return;
        }
        if (isPhoneExist(contact.phone)) {
            System.out.println("Phone number exists ");
            return;
        }

        if (index == contacts.length) {

            Contact[] newArr = new Contact[contacts.length * 2];

            for (int i = 0; i < contacts.length; i++) {
                newArr[i] = contacts[i];
            }

            contacts = newArr;

        }

        contacts[index] = contact;
        index++;
        System.out.println("Contact added. ");
    }


    public boolean isPhoneExist(String phone) {
        for (Contact contact : contacts) {
            if (contact != null && contact.phone.equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public void printContactList() {
        for (Contact c : contacts) {
            if (c != null) {
                System.out.println(c.surname + " " + c.name + " " + c.phone);
            }
        }
    }

    public String getQuery() {
        System.out.print("Enter query: ");

        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public void search(String query) {
        query = query.toLowerCase();
        for (Contact contact : contacts) {
            if (contact != null) {
                if (contact.surname.toLowerCase().contains(query) || contact.name.toLowerCase().contains(query)
                        || contact.phone.contains(query)) {
                    System.out.println(contact.surname + " " + contact.name + " " + contact.phone);
                }
            }
        }
        System.out.println("Nothing found!");
    }


    public String deleteContact() {
        System.out.print("Enter phone: ");

        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public void deleteContactFromArray(String phone) {
        for (int i = 0; i < contacts.length; i++) {
            Contact contact = contacts[i];
            if (contact != null && contact.phone.equals(phone)) {
                contacts[i] = null;
                System.out.println("Contact deleted");
                break;
            }
        }
    }
}