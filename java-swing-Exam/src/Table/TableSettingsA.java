package Table;

public class TableSettingsA {
    private String firstName;
    private String lastName;
    private int age;

    public void setData(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        displayData();
    }

    public void displayData() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
    }
}