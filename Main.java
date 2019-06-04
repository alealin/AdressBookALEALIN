import DAO.Impl.ContactDAOImpl;
import Service.ComandLineService;
import Service.Impl.ComandLineServceImpl;
import Service.Impl.ContactServiceImpl;

import java.util.Scanner;

public class Main {
    private static final Scanner scaner = new Scanner(System.in);
    private static final ContactServiceImpl contactService = new ContactServiceImpl();
    private static final ComandLineServceImpl comandLineServce = new ComandLineServceImpl();
    private static final ContactDAOImpl contactDAO = new ContactDAOImpl();
    public static void main (String[] args){

        ComandLineService.run(scaner, contactService, contactDAO, comandLineServce);
    }
}
