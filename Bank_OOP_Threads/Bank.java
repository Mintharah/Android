import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private int nextAccountNum = 1000;

    public Account createAccount(String password, String ownerName, double initialBalance){
        String accNum = String.valueOf(nextAccountNum++);
        Account newAccount = new Account(accNum, password, ownerName, initialBalance);
        accounts.put(accNum, newAccount);
        return newAccount;
    }

    public Account login(String accountNumber, String password){
        Account account = accounts.get(accountNumber);
        if(account == null){
            return null;
        }
        if(!account.checkPassword(password)){
            return null;
        }
        return account;
    }

    public boolean transfer(Account from, String toAccountNumber, double amount){
        Account to = accounts.get(toAccountNumber);
        if (to == null) {
            return false;
        }
        if (!from.withdraw(amount)) {
            return false;
        }
        to.deposit(amount);
        return true;
    }
}