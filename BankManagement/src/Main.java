public class Main {
    public static void main(String[] args) {
        // 팩토리 객체 생성
        AccountFactory savingAccountFactory = new SavingAccountFactory();
        AccountFactory checkingAccountFactory = new CheckAccountFactory();

        // 저축 계좌 생성
        Account savingAccount = savingAccountFactory.createAccount(10000);

        // 체크 계좌 생성
        Account checkingAccount = checkingAccountFactory.createAccount(10000);

        // 저축 계좌 입금
        savingAccount.deposit(500);
        System.out.println("입금 금액 : " + savingAccount.getBalance());

        // 체크 계좌 출금
        checkingAccount.withdraw(1000);
        System.out.println("출금 금액 : " + checkingAccount.getBalance());
    }
}