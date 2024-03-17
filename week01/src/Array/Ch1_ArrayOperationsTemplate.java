package src.Array;

class ArrayOperations {
    private int[] array;
    private int size;

    public ArrayOperations(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // k번째 요소에 값 삽입
    public void insertAt(int k, int value) {
        // 배열의 크기를 초과하는 위치에 삽입할 경우
        if (k > size || k < 0) {
            System.out.println("잘못된 위치");
            return;
        }

        // 배열의 크기가 최대 크기에 도달한 경우
        if (size == array.length) {
            System.out.println("배열이 가득 찼음");
            return;
        }

        // 요소 삽입 위치부터 배열 끝까지 요소를 한칸씩 뒤로 밀기
        for (int i = size; i > k; i--) array[i] = array[i - 1];

        // 값 삽입
        array[k] = value;
        size++;
    }

    // k번째 요소 삭제
    public void deleteAt(int k) {
        if (k >= size || k < 0) {
            System.out.println("잘못된 위치");
            return;
        }

        for (int i = k; i < size - 1; i++) array[i] = array[i + 1];

        size--;
    }

    // k번째 요소 검색
    public int searchAt(int k) {
        if (k >= size || k < 0) {
            System.out.println("잘못된 위치");
            return -1;
        }

        return array[k];
    }

    // 요소 끝에 삽입
    public void append(int value) {
        if (size == array.length) {
            System.out.println("배열이 가득참");
            return;
        }

        array[size] = value;
        size++;
    }

    // 마지막 요소 삭제
    public void removeLast() {
        if (size == 0) {
            System.out.println("배열이 비었음");
            return;
        }

        size--;
    }

    // 배열의 모든 요소 출력
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // 줄바꿈
    }

    // 배열의 현재 크기 반환
    public int getSize() {
        return size;
    }
}

public class Ch1_ArrayOperationsTemplate {
    public static void main(String[] args) {
        int[] testArr = {0, 1, 2, 3, 4, 5};
        String[] testStrArr = {"Volvo", "KIA", "LEXUS", "FORD"};
        System.out.println("testArr: " + testArr[1]);
        System.out.println("testStrArr: " + testStrArr[1]);

        ArrayOperations arrayOperations = new ArrayOperations(10);

        // 요소 추가
        arrayOperations.append(5); // 배열 끝에 5 추가
        arrayOperations.printArray();

        // 지정된 위치에 요소 삽입
        arrayOperations.insertAt(0, 3); // 0번 인덱스에 3 삽입
        arrayOperations.printArray();

        // 지정된 위치의 요소 삭제
        arrayOperations.deleteAt(1); // 1번 인덱스의 요소 삭제
        arrayOperations.printArray();

        // 배열의 인덱스 접근하여 출력
        for (int i = 0; i < arrayOperations.getSize(); i++) {
            System.out.println("array[" + i + "]: " + arrayOperations.searchAt(i));
        }
    }
}