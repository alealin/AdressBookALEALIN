package Service.Impl;

import Constants.ConstantsMessages;
import Entity.Contact;
import Service.ContactService;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class ContactServiceImpl implements ContactService {

    public Contact createContact(Scanner scanner) {
        Contact contact = new Contact();
        System.out.println("Enter name.");
        contact.setName(scanner.next());
        System.out.println("Enter surname.");
        contact.setSername(scanner.next());
        boolean end = false;
        do {
            System.out.println("Enter age.");
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                if ((0 <= age) && (age <= 150)) {
                    contact.setAge(age);
                    end = true;
                } else {
                    System.out.println(ConstantsMessages.STRANGE_VALUE);
                }
            } else {
                System.out.println(ConstantsMessages.STRANGE_VALUE);
                scanner.next();
            }
        } while (!end);
        end = false;
        do {
            System.out.println("Enter height in the format \"m,cm.\".");
            if (scanner.hasNextDouble()) {
                double height = scanner.nextDouble();
                if ((0 <= height) && (height <= 3)) {
                    contact.setHeight(height);
                    end = true;
                } else {
                    System.out.println(ConstantsMessages.STRANGE_VALUE);
                }
            } else {
                System.out.println(ConstantsMessages.STRANGE_VALUE);
                scanner.next();
            }
        } while (!end);
        System.out.println("Enter Y if married.");
        String check = "y";
        if (Objects.equals(scanner.next(), check)) {
            contact.setMaried(true);
        }
        System.out.println("Enter phone.");
        contact.setPhoneNumber(scanner.next().replaceAll("[^0-9+]", ""));
        contact.setCreateDate(new Date());
        return contact;
    }

    public Contact updateContact(Scanner scanner, Contact contact) {
        boolean end = false;
        do {
            System.out.println("Choose parametr to edit:\n1.Name.\n2.Sername.\n3.Age.\n4.Height.\n5.Metrial status.t" + "4.Phone number.\n0.End editing.");
            switch (scanner.nextInt()) {
                case 1: {
                    System.out.println("Enter new name");
                    contact.setName(scanner.next());
                    break;
                }
                case 2: {
                    System.out.println("Enter new surname");
                    contact.setSername(scanner.next());
                    break;
                }
                case 3: {
                    boolean stop = false;
                    do {
                        System.out.println("Enter age.");
                        if (scanner.hasNextInt()) {
                            int age = scanner.nextInt();
                            if ((0 <= age) && (age <= 150)) {
                                contact.setAge(age);
                                stop = true;
                            } else {
                                System.out.println(ConstantsMessages.STRANGE_VALUE);
                            }
                        } else {
                            System.out.println(ConstantsMessages.STRANGE_VALUE);
                            scanner.next();
                        }
                    } while (!stop);
                    break;
                }
                case 4: {
                    boolean stop = false;
                    do {
                        System.out.println("Enter height in the format \"m,cm.\".");
                        if (scanner.hasNextDouble()) {
                            double height = scanner.nextDouble();
                            if ((0 <= height) && (height <= 3)) {
                                contact.setHeight(height);
                                stop = true;
                            } else {
                                System.out.println(ConstantsMessages.STRANGE_VALUE);
                            }
                        } else {
                            System.out.println(ConstantsMessages.STRANGE_VALUE);
                            scanner.next();
                        }
                    } while (!stop);
                    break;
                }
                case 5: {
                    System.out.println("Enter Y if married.");
                    String check = "y";
                    if (Objects.equals(scanner.next(), check)) {
                        contact.setMaried(true);
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter new phone");
                    contact.setPhoneNumber(scanner.next().replaceAll("[^0-9+]", ""));
                    break;
                }
                case 0: {
                    System.out.println(ConstantsMessages.RETURNE_TO_PREVIOUS_MENU);
                    end = true;
                    break;
                }
                default: {
                    System.out.println(ConstantsMessages.WRONG_DATA_INPUT);
                }
            }
        } while (!end);
        return contact;
    }
}