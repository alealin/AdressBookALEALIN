package Service;

import DAO.Impl.ContactDAOImpl;
import Service.Impl.ComandLineServceImpl;
import Service.Impl.ContactServiceImpl;

import java.util.Scanner;

public interface ComandLineService {

    /**
     * Method showing the program menu.
     */
    void showMenu();

    /**
     * Entry point in the application
     *
     * @param scanner            scanner of console input.
     * @param contactServiceImpl service that work with obgect from DAO.
     * @param contactDAOImpl     service that work with DAO layer.
     */
    void run(Scanner scanner, ContactServiceImpl contactServiceImpl,
             ContactDAOImpl contactDAOImpl);
}