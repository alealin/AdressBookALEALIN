package Service.Impl;


import Service.ComandLineService;

public class ComandLineServceImpl implements ComandLineService {

    public void showMenu (){
        System.out.println("Choose your wish:" + '\n' + "1.Show all contacts"
                + '\n' + "2.Add new contact" + '\n' + "3.Find contact" + '\n' + "0.Exit");
    }
}
