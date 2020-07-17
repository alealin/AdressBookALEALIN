package DAO;

import Entity.Contact;
import Exception.ContactBookException;

import java.util.Scanner;

public interface ContactDAO {

    /**
     * Method gets all contacts from store.
     * @param store store of all contacts.
     * @return store of all contacts.
     */
    Contact[] getAllContactsFromStore(Contact[] store);

    /**
     * Method searcin contact with needed params in all store.
     * @param scanner scanner of console input.
     * @param store store of all contacts.
     * @return contact with needed params.
     */
    Contact findContactByParametrs(Scanner scanner, Contact[] store) throws ContactBookException;

    /**
     * Method add new contact in store.
     * @param contact new contact .
     * @param store store of all contacts.
     */
    void addNewContactInStore(Contact contact, Contact[] store) throws ContactBookException;

    /**
     * Method saving contact wich alredy exist in store after updating.
     * @param contact contact wich need to save in store after updating.
     * @param store store of all contacts.
     */
    void saveContactInStore(Contact contact, Contact[] store);

    /**
     * Method delete contact from store.
     * @param contact alredy exist contact.
     * @param store store of all contacts.
     */
    void deleteContactFromStore(Contact contact, Contact[] store);
}
