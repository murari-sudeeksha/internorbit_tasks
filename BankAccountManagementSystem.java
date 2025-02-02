import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

class BankAccount {
    private String accountNumber;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public BankAccount(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactionHistory.add(new Transaction(new Date(), "Deposit", amount));
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            transactionHistory.add(new Transaction(new Date(), "Withdrawal", amount));
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return this.balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }

    public boolean changePin(String oldPin, String newPin) {
        if (oldPin.equals(this.pin)) {
            this.pin = newPin;
            return true;
        }
        return false;
    }

    public boolean calculateInterest(double rate) {
        double interest = this.balance * rate;
        this.balance += interest;
        transactionHistory.add(new Transaction(new Date(), "Interest", interest));
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }
}

class Transaction {
    private Date timestamp;
    private String type;
    private double amount;

    public Transaction(Date timestamp, String type, double amount) {
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(timestamp) + " - " + type + ": " + amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public boolean createAccount(String accountNumber, String pin, double initialBalance) {
        if (findAccount(accountNumber) == null) {
            accounts.add(new BankAccount(accountNumber, pin, initialBalance));
            return true;
        }
        return false;
    }

    public BankAccount authenticate(String accountNumber, String pin) {
        BankAccount account = findAccount(accountNumber);
        if (account != null && account.getPin().equals(pin)) {
            return account;
        }
        return null;
    }

    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public BankAccount getAccount(String accountNumber) {
        return findAccount(accountNumber);
    }

}

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("12345", "1234", 1000);
        BankAccount userAccount = bank.authenticate("12345", "1234");

        if (userAccount != null) {
            System.out.println("Authentication successful!");
            userAccount.deposit(500);
            userAccount.withdraw(200);
            System.out.println("Current balance: " + userAccount.checkBalance());
            userAccount.calculateInterest(0.05); 
            System.out.println("Balance after interest: " + userAccount.checkBalance());

            System.out.println("\nTransaction History:");
            for (Transaction transaction : userAccount.getTransactionHistory()) {
                System.out.println(transaction);
            }

            if (userAccount.changePin("1234", "5678")) {
                System.out.println("PIN changed successfully.");
            }

             userAccount = bank.authenticate("12345", "5678"); 
            if (userAccount != null) {
                System.out.println("Login Successful with the new PIN");
            }



        } else {
            System.out.println("Authentication failed.");
        }

          userAccount = bank.authenticate("12345", "9999");
        if (userAccount != null) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Authentication failed");
        }


        userAccount = bank.authenticate("99999", "1234"); 
        if (userAccount != null) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Authentication failed");
        }
    }
}