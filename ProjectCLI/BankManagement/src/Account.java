abstract class Account {
    protected double balance;
    public Account(double balance) {
        this.balance = balance;
    }

    // 공통 추상 메소드
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    // 잔액 조회 메소드
    public double getBalance() {
        return balance;
    }

    // 잔액 변경 메소드 (입출금시 변경됨)
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// 저축 계좌
class SavingAccount extends Account {
    public SavingAccount(double balance) {
        super(balance);
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
}

// 체크 계좌
class CheckingAccount extends Account {
    public CheckingAccount(double balance) {
        super(balance);
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
}

// 계좌 팩토리 인터페이스
interface AccountFactory {
    Account createAccount(double balance);
}

// 저축 계좌 팩토리
class SavingAccountFactory implements AccountFactory {
    public Account createAccount(double balance) {
        return new SavingAccount(balance);
    }
}

// 체크 계좌 팩토리
class CheckAccountFactory implements AccountFactory {
    public Account createAccount(double balance) {
        return new CheckingAccount(balance);
    }
}