package Service.Impl;


import Entity.Contact;
import Service.ContactService;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;


public class ContactServiceImpl implements ContactService {


    public Contact createContact(Scanner scanner) {
        Contact contact = new Contact();

        System.out.println("Enter name.");
        contact.setName(scanner.next());

        System.out.println("Enter surname.");
        String surname = scanner.next();
        contact.setSername(surname);

        System.out.println("Enter age.");
        int age = scanner.nextInt();
        contact.setAge(age);

        System.out.println("Enter height in the format \"m,cm.\".");
        contact.setHeight(scanner.nextDouble());

        System.out.println("Enter marital status.");
        System.out.println("Enter Y if married or N if not.");
        String status = scanner.next();
        String check = "y";
        if (Objects.equals(status, check)) {
            contact.setMaried(true);
        }

        System.out.println("Enter phone.");
        String phoneNumber = scanner.next().replaceAll("[^0-9+]", "");
        contact.setPhoneNumber(phoneNumber);

        contact.setCreateDate(LocalDateTime.now());


        return contact;

    }

    public Contact updateContact(Scanner scanner, Contact contact) {
        boolean save = false;
        do {
            System.out.println("Choose parametr to edit:" + '\n' + "1. Name." + '\n' + "2. Sername." + '\n' + "3. Phone." + '\n' + "0. Save.");
            switch (scanner.nextInt()) {
                case 1: {
                    System.out.println("Enter new name");
                    String name = scanner.next();
                    contact.setName(name);
                    break;
                }

                case 2: {
                    System.out.println("Enter surname");
                    String surname = scanner.next();
                    contact.setSername(surname);
                }

                case 3: {
                    System.out.println("Enter phone");
                    String phoneNumber = scanner.next().replaceAll("[^0-9+]", "");
                    contact.setPhoneNumber(phoneNumber);
                }
                case 0: {
                    System.out.println("Thanks. Good bye.");
                    save = true;
                    break;
                }
                default: {
                    System.out.println("Sorry, You enter wrong number. Choose enother number");
                }
            }
        }
        while (!save);
        return contact;
    }


}