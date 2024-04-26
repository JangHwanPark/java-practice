package JavaUpDownCasting;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    String check;

    Student(String name) {
        super(name);
        this.check = "Studying hard!";
    }

    void displayCheck() {
        System.out.println("Student's status: " + check);
    }

    @Override
    void display() {
        super.display(); // 부모 클래스의 display() 메소드 호출
        displayCheck(); // Student의 추가된 메소드 호출
    }
}