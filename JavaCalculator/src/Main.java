public class Main {
    private OperationStrategy strategy;

    public Main(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeOperation(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // AdditionStrategy 인스턴스 생성 후 Main 클래스로 전달
        OperationStrategy additionStrategyInstance = new AdditionStrategy();
        Main calculator = new Main(additionStrategyInstance);

        // 덧셈 연산 실행 (AdditionStrategy)
        int add = calculator.executeOperation(5, 3);
        System.out.println("ADD : " + add);
        
        // 전략을 뺄셈으로 변경
        OperationStrategy subtractionStrategyInstance = new SubtractionStrategy();
        int minus = calculator.executeOperation(5, 3);
        System.out.println("Minus Before : " + minus);
        calculator.setStrategy(subtractionStrategyInstance);
        int minus2 = calculator.executeOperation(5, 3);
        System.out.println("Minus After : " + minus2);
    }
}