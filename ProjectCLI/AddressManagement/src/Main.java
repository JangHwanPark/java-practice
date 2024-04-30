import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

interface Accountable {
    void addAccountInfo(String name, int age, String address);
    void printAllAccounts();
    Person searchAccountByName(String name);
}

class Person {
    String name;
    int age;
    String address;

    // 생성자
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("\n이름: %s\n나이: %d\n주소: %s", this.name, this.age, this.address);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

class AddressBook implements Accountable {
    Integer key = 1;
    HashMap<Integer, Person> addressBook = new HashMap<>();

    @Override
    public void addAccountInfo(String name, int age, String address) {
        addressBook.put(key++, new Person(name, age, address));
    }

    @Override
    public void printAllAccounts() {
        if (addressBook.isEmpty()) System.out.println("System: 주소록 내 사용자가 존재하지 않습니다.");
        else addressBook.values().forEach(System.out::println);
    }

    @Override
    public Person searchAccountByName(String name) {
        for (Person person : addressBook.values()) {
            if (person.name.equals(name)) return person;
        }
        return null;
    }
}

class AccountManager implements Accountable {
    private AddressBook accountManager = new AddressBook();

    @Override
    public void addAccountInfo(String name, int age, String address) {
        accountManager.addAccountInfo(name, age, address);
    }

    @Override
    public void printAllAccounts() {
        accountManager.printAllAccounts();
    }

    @Override
    public Person searchAccountByName(String name) {
        return accountManager.searchAccountByName(name);
    }
}

class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private AccountManager accountManager = new AccountManager();
    String systemConsole = "System", userConsole = "User";

    public void defaultDisplay() {
        System.out.println("\n\n========== 주소록 ==========");
        System.out.println("1. 사용자 등록\n2. 전체 사용자 검색\n3. 이름으로 검색\n4. 종료");
        System.out.println("===========================");
    }

    public void addAccount() {
        System.out.println(systemConsole + ": 사용자 이름을 입력해주세요.");
        System.out.print(userConsole + ": ");
        String name = scanner.next();

        System.out.println(systemConsole + ": 사용자 나이를 입력해주세요.");
        System.out.print(userConsole + ": ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println(systemConsole + ": 사용자 주소를 입력해주세요.");
        System.out.print(userConsole + ": ");
        String address = scanner.nextLine();

        accountManager.addAccountInfo(name, age, address);
        System.out.println(systemConsole + ": 사용자 등록이 완료되었습니다.");
        goToMainMenu(this::addAccount);
    }

    public void searchAccountByName() {
        System.out.println(systemConsole + ": 검색할 사용자 이름을 입력해주세요.");
        System.out.print(userConsole + ": ");
        String name = scanner.next();
        Person findPerson = accountManager.searchAccountByName(name);

        if (findPerson != null) System.out.println(findPerson.toString());
        else System.out.println(systemConsole + ": 해당 이름의 사용자를 찾을 수 없습니다.");
        goToMainMenu(this::searchAccountByName);
    }

    public void goToMainMenu(Runnable currentAction) {
        System.out.println(systemConsole + ": 작업을 계속 하시겠습니까? (y/n)");
        System.out.print(userConsole + ": ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) currentAction.run();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            defaultDisplay();
            System.out.print(userConsole + ": ");
            int selectNumber = scanner.nextInt();

            switch (selectNumber) {
                case 1:
                    System.out.println(systemConsole + ": 사용자를 등록합니다.");
                    addAccount();
                    break;
                case 2:
                    System.out.println(systemConsole + ": 전체 사용자를 검색합니다.");
                    accountManager.printAllAccounts();
                    break;
                case 3:
                    System.out.println(systemConsole + ": 이름으로 사용자를 검색합니다.");
                    searchAccountByName();
                    break;
                case 4:
                    isRunning = false;
                    System.out.println(systemConsole + ": 프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println(systemConsole + ": 올바른 명령을 입력해주세요.");
                    break;
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.run();
    }
}