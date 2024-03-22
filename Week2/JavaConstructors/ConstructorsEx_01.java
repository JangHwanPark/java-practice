package JavaConstructors;

class ConstructorParam {
    int x;

    public ConstructorParam(int y) {
        x = y;
    }

    public void printConstructorParam() {
        System.out.println("매개변수y(x)값은 " + x + "입니다.");
    }
}

class ConstructorThis {
    int x;
    
    public ConstructorThis(int x) {
        this.x = x;
    }
    
    public void printConstructorThis() {
        System.out.println("매개변수x(this.x)값은 " + x + "입니다.");
    }
}

public class ConstructorsEx_01 {
    // Default(디폴트-기본 생성자)
    public ConstructorsEx_01() {}

    public static void main(String[] args) {
        // 파라미터로 값을받아 할당하기
        ConstructorParam paramValue = new ConstructorParam(5);
        paramValue.printConstructorParam();
        
        // This로 값을받아 할당하기
        ConstructorThis thisValue = new ConstructorThis(5);
        thisValue.printConstructorThis();
    }
}