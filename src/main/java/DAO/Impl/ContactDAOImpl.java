package DAO.Impl;


import Constants.ConstantsMessages;
import Constants.ResponseCode;
import DAO.ContactDAO;
import Entity.Contact;
import Exception.ContactBookException;

import java.util.Objects;
import java.util.Scanner;

import static Constants.ConstantsMessages.FIND_MENU;
import static Constants.ConstantsMessages.WRONG_DATA_INPUT;


public class ContactDAOImpl implements ContactDAO {

    Contact[] store = new Contact[10];

    public Contact[] getAllContactsFromStore(Contact[] store) {
        return store;
    }

    public Contact findContactByParametrs(Scanner scanner, Contact[] store) throws ContactBookException {
        Contact contactTemp = null;
        boolean end = false;
        do {
            System.out.println(FIND_MENU);
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1: {
                        contactTemp = findByID(scanner,store,contactTemp);
                        end = true;
                        break;
                    }

                    case 2: {
                        contactTemp = findByName(scanner,store,contactTemp);
                        end = true;
                        break;
                    }

                    case 3: {
                        contactTemp = findBySername(scanner,store,contactTemp);
                        end = true;
                        break;
                    }

                    case 4: {
                        contactTemp = findByPhone (scanner,store,contactTemp);
                        end = true;
                        break;
                    }

                    case 0: {
                        System.out.println(ConstantsMessages.CONTINUE);
                        end = true;
                        break;
                    }

                    default: {
                        System.out.println(WRONG_DATA_INPUT);
                    }

                }

            } else {
                System.out.println(WRONG_DATA_INPUT);
                scanner.next();
            }
        } while (!end);
        if (Objects.isNull(contactTemp)) {
            throw new ContactBookException(ResponseCode.CONTACT_NOT_FOUND, ConstantsMessages.CONTACT_NOT_FOUND);
        }
        return contactTemp;
    }

    public void addNewContactInStore(Contact contact, Contact[] store) throws ContactBookException {
        for (int argument = 0; argument < store.length; argument++) {
            if (Objects.equals(store[argument], contact)) {
                System.out.println(store[argument]);
                throw new ContactBookException(ResponseCode.CONTACT_EXIST, ConstantsMessages.CONTACT_EXIST);
            }
        }
        for (int argument = 0; argument < store.length; argument++) {
            if (store[argument] == null) {
                contact.setId(argument);
                store[argument] = contact;
                System.out.println("New conntact saved to store.");
                break;
            }
        }
    }

    public Contact findByID (Scanner scanner, Contact[] store, Contact contactTemp) {
        boolean end = false;
        do {
            System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR + "You need choose from 0 to " + (store.length - 1) + ".");
            if (scanner.hasNextInt()) {
                int searchParam = scanner.nextInt();
                if ((0 <= searchParam) && (searchParam <= (store.length - 1))) {
                    for (int argument = 0; argument < store.length; argument++) {
                        if ((Objects.nonNull(store[argument])) && (store[argument].getId() == searchParam)) {
                            contactTemp = store[argument];
                            break;
                        }
                    }
                    end = true;
                } else {
                    System.out.println(ConstantsMessages.WRONG_DATA_INPUT);
                }
            }else {
                System.out.println(ConstantsMessages.WRONG_DATA_INPUT);
                scanner.next();
            }
        } while (!end);
        return contactTemp;
    }

    public Contact findByName (Scanner scanner, Contact[] store, Contact contactTemp) {
        System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR);
        String searchParam = scanner.next();
        for (int argument = 0; argument < store.length; argument++) {
            if (Objects.nonNull(store[argument]) && Objects.equals(store[argument].getName(), searchParam)) {
                contactTemp = store[argument];
                break;
            }
        }
        return contactTemp;
    }

    public Contact findBySername (Scanner scanner, Contact[] store, Contact contactTemp) {
        System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR);
        String searchParam = scanner.next();
        for (int argument = 0; argument < store.length; argument++) {
            if (Objects.nonNull(store[argument]) && Objects.equals(store[argument].getSername(), searchParam)) {
                contactTemp = store[argument];
                break;
            }
        }
        return contactTemp;
    }

    public Contact findByPhone (Scanner scanner, Contact[] store, Contact contactTemp) {
        System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR);
        String searchParam = scanner.next();
        for (int argument = 0; argument < store.length; argument++) {
            if (Objects.nonNull(store[argument]) && Objects.equals(store[argument].getPhoneNumber(), searchParam)) {
                contactTemp = store[argument];
                break;
            }
        }
        return contactTemp;
    }

    public void saveContactInStore(Contact contact, Contact[] store) {
        store[contact.getId()] = contact;
        System.out.println("Conntact saved to store.");
    }

    public void deleteContactFromStore(Contact contact, Contact[] store) {
        store[contact.getId()] = null;
    }

    public Contact[] getStore() {
        return store;
    }


}
