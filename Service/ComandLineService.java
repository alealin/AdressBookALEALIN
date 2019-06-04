package Service;

import DAO.Impl.ContactDAOImpl;
import Entity.Contact;
import Service.Impl.ComandLineServceImpl;
import Service.Impl.ContactServiceImpl;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public interface ComandLineService {

    /**
     * Method showing the program menu.
     */
    void showMenu();

    /**
     * Entry point in the application
     * @param scanner scanner of console input.
     * @param contactServiceImpl service that work with obgect from DAO.
     * @param contactDAOImpl service that work with DAO layer.
     * @param comandLineServce service that work with user.
     */
    static void run(Scanner scanner, ContactServiceImpl contactServiceImpl,
                    ContactDAOImpl contactDAOImpl, ComandLineServceImpl comandLineServce) {

        boolean exit = false;
        do {

            comandLineServce.showMenu();

            switch (scanner.nextInt()) {
                case 1: {
                    System.out.println(Arrays.toString(contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore())));
                    break;
                }
                case 2: {
                    contactDAOImpl.addNewContactInStore(contactServiceImpl.createContact(scanner), contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                    break;
                }
                case 3: {
                    Contact contactTemp = contactDAOImpl.findContactByParametrs(scanner, contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                    if (Objects.isNull(contactTemp)){
                        break;
                    }
                    System.out.println("Choose your wish:" + '\n' + "1. Show contact." + '\n' + "2. Update contact." + '\n' + "3. Delete contact.");
                    switch (scanner.nextInt()) {
                        case 1: {
                            System.out.println(contactTemp);
                            break;
                        }

                        case 2: {

                            contactDAOImpl.saveContactInStore(contactServiceImpl.updateContact(scanner, contactTemp), contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                            break;
                        }
                        case 3: {
                            contactDAOImpl.deleteContactFromStore(contactTemp, contactDAOImpl.getAllContactsFromStore(contactDAOImpl.getStore()));
                            break;
                        }
                        default: {
                            System.out.println("Sorry, You enter wrong number. Choose enother number");
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
                    System.out.println("Sorry, You enter wrong number. Choose enother number");
                }
            }
        }
        while (!exit);
    }
}
