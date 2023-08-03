import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // start ATM system show the Welcome Page!!
    public void start(){
        while(true){
            System.out.println("=========Welcome to the Happy Bank ATM=========");
            System.out.println("1.Login Account" );
            System.out.println("2.Create an account" );
            System.out.println("Please choose a function");
            String command = sc.next();
        
            switch(command){
                case "1" :
                    login(); // login account
                    break;
                case "2" :
                    create(); // create account
                    break;
                default :
                    System.out.println("We don't hava this function");
                    System.out.println("Please choose again!!");
            }
        }
    }

    public void login(){

    }

    public void create(){

    }
}
