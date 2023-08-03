public class Account {
    private String accountNumber;
    private String name;
    private char sex;
    private String password;
    private double money;
    private double limit;

    public Account(String name, char sex, String password, double money, double limit ,String accountNumber) {
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.money = money;
        this.limit = limit;
        this.accountNumber = accountNumber;
    }

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    } 
    public String getName() {
        return name;
    }
    public char getSex() {
        return sex;
    }
    public String getPassword() {
        return password;
    }
    public double getMoney() {
        return money;
    }
    public double getLimit() {
        return limit;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
}
