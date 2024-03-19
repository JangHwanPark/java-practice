class Point {
    private int x, y;
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void printPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}

class ColorPoint extends Point {
    private String color;
    public void setColor(String color) {
        this.color = color;
    }

    public void printColorPoint() {
        System.out.println("color: " + color);
        printPoint();
    }
}

class Exam03 extends ColorPoint {
    private String exam;
    public void set(String exam) {
        this.exam = exam;
    }

    public void printSet() {
        System.out.println(exam);
        printPoint();
    }
}

public class ColorPointEx {
    public static void main(String[] args) {
        // Point
        Point point = new Point();
        point.setXY(1, 2);
        point.printPoint();

        // ColorPoint
        ColorPoint colorPoint = new ColorPoint();
        colorPoint.setXY(3, 4);
        colorPoint.setColor("red");
        colorPoint.printColorPoint();

        Exam03 exam03 = new Exam03();
        exam03.setXY(10, 20);
        exam03.setColor("blue");
        exam03.set("삼각형");
        exam03.printSet();
    }
}
