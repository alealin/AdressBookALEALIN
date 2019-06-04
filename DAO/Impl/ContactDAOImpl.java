package DAO.Impl;

import Entity.Contact;
import java.util.Objects;
import java.util.Scanner;

public class ContactDAOImpl {

    Contact[] store = new Contact[10];

    public Contact[] getAllContactsFromStore(Contact[] store) {
        return store;
    }

    public Contact findContactByParametrs(Scanner scanner, Contact[] store) {
        System.out.println("Choose your parametr:" + '\n' + "1.Find by ID."
                + '\n' + "2.Find by name." + '\n' + "3.Find by sernme." + '\n' + "4.Find by number.");
        Contact contactTemp = null;
        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("Enter parametr from 1 to " + store.length + ".");
                int searchParam = scanner.nextInt() - 1;
                for (int argument = 0; argument < store.length; argument++) {
                    if (Objects.nonNull(store[argument]) && store[argument].getId() == searchParam) {
                        contactTemp = store[argument];
                        break;
                    }
                }
                if (Objects.isNull(contactTemp)) {
                    System.out.println("Not found");
                }
                break;
            }

            case 2: {
                System.out.println("Enter parametr.");
                String searchParam = scanner.next();
                for (int argument = 0; argument < store.length; argument++) {
                    if (Objects.nonNull(store[argument]) && store[argument].getName() == searchParam) {
                        contactTemp = store[argument];
                        break;
                    }
                }
                if (Objects.isNull(contactTemp)) {
                    System.out.println("Not found");
                }
                break;
            }

            case 3: {
                System.out.println("Enter parametr.");
                String searchParam = scanner.next();
                for (int argument = 0; argument < store.length; argument++) {
                    if (Objects.nonNull(store[argument]) && store[argument].getSername() == searchParam) {
                        contactTemp = store[argument];
                        break;
                    }
                }
                if (Objects.isNull(contactTemp)) {
                    System.out.println("Not found");
                }
                break;
            }

            case 4: {
                System.out.println("Enter parametr.");
                String searchParam = scanner.next();
                for (int argument = 0; argument < store.length; argument++) {
                    if (Objects.nonNull(store[argument]) && store[argument].getPhoneNumber() == searchParam) {
                        contactTemp = store[argument];
                        break;
                    }
                }
                if (Objects.isNull(contactTemp)) {
                    System.out.println("Not found");
                }
                break;
            }

            default: {
                System.out.println("Sorry, You enter wrong number. Choose enother number");
            }

        }
        return contactTemp;
    }

    public void addNewContactInStore(Contact contact, Contact[] store) {
        for (int argument = 0; argument < store.length; argument++) {
            if (store[argument] == null) {
                contact.setId(argument);
                store[argument] = contact;
                System.out.println("Conntact saved to store.");
                break;
            }
        }
    }

    public void saveContactInStore(Contact contact, Contact[] store) {
        store[contact.getId()] = contact;
    }

    public void deleteContactFromStore(Contact contact, Contact[] store) {
        store[contact.getId()] = null;
    }

    public Contact[] getStore() {
        return store;
    }


}
