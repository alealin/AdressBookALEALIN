package Service.Impl;


import DAO.Impl.ContactDAOImpl;
import Entity.Contact;
import Exception.ContactBookException;
import Service.ComandLineService;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static Constants.ConstantsMessages.*;

public class ComandLineServceImpl implements ComandLineService {

    public void showMenu (){
        System.out.println(MAIN_MENU);
    }

    public void run(Scanner scanner, ContactServiceImpl contactServiceImpl,
                    ContactDAOImpl contactDAOImpl) {

        Contact test = new Contact(0, "test","test", 20, 1.75, true, "0",null);
        contactDAOImpl.getStore()[0]=test;


        boolean exit = false;
        do {
            showMenu();
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1: {
                        System.out.println(Arrays.toString(contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore())));
                        break;
                    }
                    case 2: {
                        try {
                            contactDAOImpl.addNewContactInStore(contactServiceImpl.createContact(scanner), contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                        } catch (ContactBookException e) {
                            e.Message();
                            System.out.println(Arrays.toString(contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore())));
                        }
                        break;
                    }
                    case 3: {
                        Contact contactTemp = null;
                        try {
                            contactTemp = contactDAOImpl.findContactByParametrs(scanner, contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                        } catch (ContactBookException e) {
                            e.Message();
                            System.out.println(CHOSE_TO_CREATE);
                            String check = "y";
                            if (Objects.equals(check, scanner.next())) {
                                try {
                                    contactDAOImpl.addNewContactInStore(contactServiceImpl.createContact(scanner), contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                                } catch (ContactBookException e1) {
                                    e1.Message();
                                    System.out.println(Arrays.toString(contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore())));
                                }
                            }
                        }
                        if (Objects.isNull(contactTemp)) {
                            break;
                        }
                        System.out.println("Choose your wish:" + '\n' + "1. Show contact." + '\n' + "2. Update contact." + '\n' + "3. Delete contact.");
                        switch (scanner.nextInt()) {
                            case 1: {
                                System.out.println(contactTemp);
                                break;
                            }
                            case 2: {
                                Contact contactUpdated = contactServiceImpl.updateContact(scanner, contactTemp);
                                System.out.println("Woud you like to save changes?\nY or N");
                                String check = "y";
                                if (Objects.equals(scanner.next(), check)) {
                                    contactDAOImpl.saveContactInStore(contactUpdated, contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                                } else {
                                    contactDAOImpl.saveContactInStore(contactTemp, contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                                }
                                break;
                            }
                            case 3: {
                                contactDAOImpl.deleteContactFromStore(contactTemp, contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                                break;
                            }
                            default: {
                                System.out.println(WRONG_DATA_INPUT);
                            }
                        }
                        break;
                    }
                    case 0: {
                        System.out.println("Thanks. Good bye.");
                        exit = true;
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
        } while (!exit);
    }
}
