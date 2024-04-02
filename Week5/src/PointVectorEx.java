import java.util.Vector;

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y =y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}

class ColorPoint extends Point {
    String color;

    public ColorPoint(int x, int y, String color) {
        super(x,y);
        this.color = color;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + color + ")";
    }
}

// Decoration -> 자식을 상속받은 ?
// 업캐스팅되면 접근범위 다운, 다운캐스팅은 원복
public class PointVectorEx {
    public static void main(String[] args) {
        Vector<Point> pointVector = new Vector<>();

        // 벡터 내 Point 객체 바로 생성(삽입)
        pointVector.add(new Point(2, 3));
        pointVector.add(new Point(-5, 20));
        pointVector.add(new Point(30, 8));

        // 색상 객체 벡터 내부에 바로 추가 Ex.(50, 60, "red)
        pointVector.add(new ColorPoint(55, 53, "red"));

        // 루프 테스트
        Vector<Point> testVector = new Vector<>();
        int testInX = 5, testInY = 20;
        String testColor = "color";
        for (int i = 0; i < 5; i++) {
            testVector.add(new ColorPoint(testInX, testInY, testColor));
            testInX++; testInY++;
            System.out.println("testVector: " + testVector.get(i));
        }

        // 1번 인덱스 요소 삭제
        pointVector.remove(1);

        // 벡터 내 Point 객체 모두 검색 -> 출력
        for(int i = 0; i < pointVector.size(); i++) {
            Point p = pointVector.get(i); // i 번째 Point 객체 얻기
            System.out.println(p); // 생성된 p 객체 출력
        }
    }
}
