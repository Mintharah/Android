public class Account {
    private String accountNumber;
    private String password;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String password, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }

    public synchronized double getBalance() {
        return balance;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}