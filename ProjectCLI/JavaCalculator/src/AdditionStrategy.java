public class AdditionStrategy implements OperationStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}