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
        Contact temp = null;
        boolean end = false;
        do {
            System.out.println(FIND_MENU);
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1: {
                        temp = findByID(scanner,store);
                        end = true;
                        break;
                    }

                    case 2: {
                        temp = findByName(scanner,store);
                        end = true;
                        break;
                    }

                    case 3: {
                        temp = findBySername(scanner,store);
                        end = true;
                        break;
                    }

                    case 4: {
                        temp = findByPhone (scanner,store);
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
        if (Objects.isNull(temp)) {
            throw new ContactBookException(ResponseCode.CONTACT_NOT_FOUND, ConstantsMessages.CONTACT_NOT_FOUND);
        }
        return temp;
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

    public Contact findByID (Scanner scanner, Contact[] store) {
        boolean end = false;
        Contact temp = null;
        do {
            System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR + "You need choose from 0 to " + (store.length - 1) + ".");
            if (scanner.hasNextInt()) {
                int searchParam = scanner.nextInt();
                if ((0 <= searchParam) && (searchParam <= (store.length - 1))) {
                    for (int argument = 0; argument < store.length; argument++) {
                        if ((Objects.nonNull(store[argument])) && (store[argument].getId() == searchParam)) {
                            return store[argument];
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
        return temp;
    }

    public Contact findByName (Scanner scanner, Contact[] store) {
        Contact temp = null;
        System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR);
        String searchParam = scanner.next();
        for (int argument = 0; argument < store.length; argument++) {
            if (Objects.nonNull(store[argument]) && Objects.equals(store[argument].getName(), searchParam)) {
                temp = store[argument];
                break;
            }
        }
        return temp;
    }

    public Contact findBySername (Scanner scanner, Contact[] store) {
        Contact temp = null;
        System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR);
        String searchParam = scanner.next();
        for (int argument = 0; argument < store.length; argument++) {
            if (Objects.nonNull(store[argument]) && Objects.equals(store[argument].getSername(), searchParam)) {
                temp = store[argument];
                break;
            }
        }
        return temp;
    }

    public Contact findByPhone (Scanner scanner, Contact[] store) {
        Contact temp = null;
        System.out.println(ConstantsMessages.ENTER_SEARCH_PARAMETR);
        String searchParam = scanner.next();
        for (int argument = 0; argument < store.length; argument++) {
            if (Objects.nonNull(store[argument]) && Objects.equals(store[argument].getPhoneNumber(), searchParam)) {
                temp = store[argument];
                break;
            }
        }
        return temp;
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
