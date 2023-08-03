public class Account {
    private int AccountNumer;
    private String name;
    private String sex;
    private int password;
    private double money;
    private double limit;

    public Account(String name, String sex, int password, double money, double limit ,int AccountNumer) {
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.money = money;
        this.limit = limit;
        this.AccountNumer = AccountNumer;
    }

    public Account() {
    }

    public int getAccountNumer() {
        return AccountNumer;
    } 
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public int getPassword() {
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
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }
    public void setAccountNumer(int accountNumer) {
        AccountNumer = accountNumer;
    }
    
}
