import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        Account currentAccount = null;

        while (true) {
            if (currentAccount == null) {
                System.out.println("\n1. Create Account");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Set a password: ");
                    String password = scanner.nextLine();
                    System.out.print("Initial deposit: ");
                    double initial = scanner.nextDouble();

                    Account created = bank.createAccount(password, name, initial);
                    System.out.println("Account created! Your account number is: " + created.getAccountNumber());

                } else if (choice == 2) {
                    scanner.nextLine();
                    System.out.print("Account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Password: ");
                    String pw = scanner.nextLine();

                    Account loggedIn = bank.login(accNum, pw);
                    if (loggedIn == null) {
                        System.out.println("Invalid account number or password.");
                    } else {
                        currentAccount = loggedIn;
                        System.out.println("Welcome, " + currentAccount.getOwnerName() + "!");
                    }

                } else if (choice == 3) {
                    System.out.println("Goodbye!");
                    break;
                }

            } else {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Check Balance");
                System.out.println("5. View Account Info");
                System.out.println("6. Logout");
                System.out.print("Choose: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("Amount to deposit: ");
                    double amount = scanner.nextDouble();
                    currentAccount.deposit(amount);
                    System.out.println("Deposited. New balance: " + currentAccount.getBalance());

                } else if (choice == 2) {
                    System.out.print("Amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    boolean success = currentAccount.withdraw(amount);
                    if (success) {
                        System.out.println("Withdrawn. New balance: " + currentAccount.getBalance());
                    } else {
                        System.out.println("Insufficient funds.");
                    }

                } else if (choice == 3) {
                    scanner.nextLine();
                    System.out.print("Recipient account number: ");
                    String toAcc = scanner.nextLine();
                    System.out.print("Amount to transfer: ");
                    double amount = scanner.nextDouble();
                    boolean success = bank.transfer(currentAccount, toAcc, amount);
                    if (success) {
                        System.out.println("Transfer successful. New balance: " + currentAccount.getBalance());
                    } else {
                        System.out.println("Transfer failed (bad account or insufficient funds).");
                    }

                } else if (choice == 4) {
                    System.out.println("Balance: " + currentAccount.getBalance());

                } else if (choice == 5) {
                    System.out.println("Account Number: " + currentAccount.getAccountNumber());
                    System.out.println("Owner: " + currentAccount.getOwnerName());
                    System.out.println("Balance: " + currentAccount.getBalance());

                } else if (choice == 6) {
                    currentAccount = null;
                    System.out.println("Logged out.");
                }
            }
        }
        scanner.close();
    }
}