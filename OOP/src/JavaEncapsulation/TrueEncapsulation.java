package JavaEncapsulation;

public class TrueEncapsulation {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public TrueEncapsulation(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        TrueEncapsulation account = new TrueEncapsulation("12345", "John Doe", 1000);
        account.deposit(500);
        System.out.println("TrueEncapsulation Balance: " + account.getBalance());
    }
}