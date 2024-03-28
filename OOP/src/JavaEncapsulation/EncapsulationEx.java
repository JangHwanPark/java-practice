package JavaEncapsulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EncapsulationPerson {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) System.out.println("나이는 0보다 작을 수 없습니다.");
        else this.age = age;
    }

    public void displayInfo() {
        System.out.println(getName());
        System.out.println(getAge());
    }
}

public class EncapsulationEx {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("나이를 입력하세요 : ");
        int in = Integer.parseInt(bf.readLine());

        EncapsulationPerson ep = new EncapsulationPerson();
        ep.setName("name");
        ep.setAge(in);
        ep.displayInfo();
    }
}