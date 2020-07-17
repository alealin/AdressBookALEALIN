import DAO.Impl.ContactDAOImpl;
import Service.Impl.ComandLineServceImpl;
import Service.Impl.ContactServiceImpl;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
    private static final ComandLineServceImpl comandLineServceImpl = new ComandLineServceImpl();
    private static final ContactDAOImpl contactDAOImpl = new ContactDAOImpl();
    public static void main (String[] args) {

        comandLineServceImpl.run(scanner, contactServiceImpl, contactDAOImpl, comandLineServceImpl);
    }
}
