import java.util.Scanner;// Scanner class import

// Interface representing ATM operations
interface ATMOperations {
    void withdraw(double amount);
    void deposit(double amount);
    void checkBalance();
}

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// Class representing the ATM machine
class ATM implements ATMOperations {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: Rs " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: Rs " + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: Rs " + userAccount.getBalance());
    }
}

// Main class to run the ATM system
public class ATM1{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
