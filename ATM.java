import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Account loginacc;
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

    // login 
    private void login(){
        System.out.println("========Login Your Acccount========");
        
        if (accounts.size() == 0 ){
            System.out.println("There are no Accounts in the System , Please create an account first");
            return;
        }
        while(true){
            System.out.println("Please Enter Your Account Number");
            String cardId = sc.next();
            Account acc = getAccountbyId(cardId);
            if (acc == null){
                System.out.println("You enter a wrong Account Number");
                System.out.println("Please enter it again");
            }else{
                while(true){
                    System.out.println("Please enter Your password");
                    String passWord = sc.next();
                    if (acc.getPassword().equals(passWord)){
                        loginacc = acc;
                        System.out.println("Congulation !!" + acc.getName() + " Mrs./ Ms. your are login. Your Account Number is: " + acc.getAccountNumber());
                        // show the Screen after login
                        showUserCommand();
                        return;
                    }else{
                        System.out.println("You enter the wrong password");
                        System.out.println("Please enter it again");
                    }
                }
            }
        }
    }

    private void showUserCommand(){
        while(true){
            System.out.println("========User Command Page========");
            System.out.println("The following is the command that can be performed by this system");
            System.out.println("Mr./Ms. "+ loginacc.getName() + " ,Please choose your command");
            System.out.println("1.Select Your Account Information");
            System.out.println("2.Deposit");
            System.out.println("3.Withdrawals");
            System.out.println("4.Transfer Your money");
            System.out.println("5.Delete Account ");
            System.out.println("6.Change the password");
            System.out.println("7.Exit the User Command");
            String command = sc.next();
            switch(command){
                case "1" : // Select Your Account Information
                    AccountInformation();
                    break;
                case "2" : // Deposit
                    Deposit();
                    break;
                case "3" : // Withdrawals
                    Withdrawals();
                    break;
                case "4" : // Transfer Your money

                    break;
                case "5" : // Delete Account

                    break;
                case "6" : // Change the password

                    break;
                case "7" : // Exit the User Command
                    System.out.println(loginacc.getName() + " Mr./Ms. You exit the User Command successfully");
                    return;
                default:
                    System.out.println("Your command is wrong ,Please choose it again");    
            
            }
        }
    }

    private void AccountInformation(){
        System.out.println("Dear " + loginacc.getName() + " Mr./Ms. Your Account Number is: "+ loginacc.getAccountNumber());
        System.out.println("The information below is your account information:");
        System.out.println("Account User: " + loginacc.getName());
        System.out.println("Account Balance: " + loginacc.getMoney());
        System.out.println("Withdrawals Limit: " + loginacc.getLimit());
    }
    
    private void Deposit(){
        System.out.println("Please enter the money you want to deposit");
        double money = sc.nextDouble();
        loginacc.setMoney(loginacc.getMoney() + money);
        System.out.println("Deposit money successfully , Your Account Balance is " + loginacc.getMoney());
    }

    private void Withdrawals(){
        if (loginacc.getMoney() < 100){
            System.out.println("Your account balance is less than $100 and you cannot withdraw the money");
            return;
        }
        while(true){
            System.out.println("Please enter the money you want to withdraw");
            double money = sc.nextDouble();
            if (loginacc.getMoney() > money){
                if (money <= loginacc.getLimit()){
                    loginacc.setMoney(loginacc.getMoney() - money);
                    System.out.println("Withdraw" + money + "money successfully , Your Account Balance now is " + loginacc.getMoney());
                    break;
                }else{
                    System.out.println("Your withdrawal exceeds the withdrawal limit. You only can withdraw: " + loginacc.getLimit());
                }
            }else {
                System.out.println("Your Account Balance is not enough , Please enter it again");
            }
        }
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
        System.out.println("Congualations !! Your Account is create !! " + acc.getName() + "Mr./Ms. Your Account Number is " + acc.getAccountNumber());
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
    }

    // the account number can't be the same as other accounts.
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
