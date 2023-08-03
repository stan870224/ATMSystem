import java.util.ArrayList;
import java.util.Random;
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

    //finish create account
    private void create(){
        System.out.println("========Create Your Acccount========");
        Account acc = new Account();


        // Enter the name
        System.out.println("Please Enter your name");
        String name = sc.next();
        acc.setName(name);

        //Enter the sex
        while(true){
            System.out.println("Please Enter your sex(male input M , female input F,Third sex input 3)");
            char sex = sc.next().toUpperCase().charAt(0);
            if (sex == 'M' || sex == 'F' || sex == '3' ){
                acc.setSex(sex);
                break;
            }else{
                System.out.println("There is no such gender");
            }
        }

        //Enter the password
        while(true){
            System.out.println("Please Enter your password");
            String password = sc.next();
            System.out.println("To confirm the password, Please enter it again");
            String okpassword = sc.next();
            if (okpassword.equals(password)){
                acc.setPassword(okpassword);
                break;
            }else{
                System.out.println("The password is difference ,Please enter it again");
            }
        }

        //Enter the limit
        System.out.println("Please Enter your limit withdrawals");
        double limit = sc.nextDouble();
        acc.setLimit(limit);

        // point : We need to use System Random an account number and it is 8 numbers,
        //         and this requirement said the account number can't be the same as other accounts.
        String cardId = createCardId();
        acc.setAccountNumber(cardId);
        
        //Put this account object to the Arraylist(Account)
        accounts.add(acc);
        System.out.println("Congualations !! Your Account is create !! " + acc.getName() + "Mr./Ms. Your Account Number is " );
    }
        
    private String createCardId(){
        //System create a Random account numer for 8 numbers
        while(true){
            String cardId ="";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);
                cardId += data;
            }
            Account acc = getAccountbyId(cardId);
            if (acc == null){
                return cardId;
            }
        }   
        // the account number can't be the same as other accounts.
        
    }

    private Account getAccountbyId(String cardId){
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getAccountNumber().equals(cardId)){
                return acc;
            }
        }
        return null;
    }
}
