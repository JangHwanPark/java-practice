package array;

class Exercise01 {
    public void printExercise01(String[] cars) {
        System.out.println("cars: " + cars[0]);
    }

    public void printChangeValue(String[] cars) {
        cars[0] = "Ope1";
        System.out.println("ChangeValue(cars): " + cars[0]);
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        String[] cars = {"Volvo", "BMW", "KIA", "Ford", "Hyundai"};
        Exercise01 exam01 = new Exercise01();
        exam01.printExercise01(cars);
        exam01.printChangeValue(cars);
    }
}