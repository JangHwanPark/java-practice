package JavaEncapsulation;

public class NotEncapsulation {
    public String accountNumber;
    public String ownerName;
    public double balance;

    public NotEncapsulation(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public static void main(String[] args) {
        NotEncapsulation account = new NotEncapsulation("12345", "John Doe", 1000);
        // 직접 접근하여 수정
        account.balance += 500;
        account.balance += 500;
        System.out.println("NotEncapsulation Balance: " + account.balance);
    }
}