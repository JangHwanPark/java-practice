package array;

class Exercise01 {
    public void printExercise01() {
        String[] cars = {"Volvo", "BMW", "KIA", "Ford", "Hyundai"};
        System.out.println("cars: " + cars[1]);
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Exercise01 exam01 = new Exercise01();
        exam01.printExercise01();
    }
}