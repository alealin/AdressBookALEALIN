package Service;

import Entity.Contact;
import java.util.Scanner;

public interface ContactService {




    /**
     * @param scanner
     * @return
     */
    Contact createContact(Scanner scanner);

    Contact updateContact(Scanner scanner, Contact contact);

}
