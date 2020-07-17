package Service;

import Entity.Contact;

import java.util.Scanner;

public interface ContactService {

    /**
     * Method create new contact.
     * @param scanner scanner of console input.
     * @return new contact
     */
    Contact createContact(Scanner scanner);

    /**
     * Method update alredy exist contact.
     * @param scanner scanner of console input.
     * @param contact alredy exist contact.
     * @return updated contact.
     */
    Contact updateContact(Scanner scanner, Contact contact);

}
