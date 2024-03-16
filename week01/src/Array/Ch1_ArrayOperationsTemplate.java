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
        // 구현 예정
    }

    // k번째 요소 삭제
    public void deleteAt(int k) {
        // 구현 예정
    }

    // k번째 요소 검색
    public int searchAt(int k) {
        // 구현 예정
        return -1; // 예시 반환값
    }

    // 요소 끝에 삽입
    public void append(int value) {
        // 구현 예정
    }

    // 마지막 요소 삭제
    public void removeLast() {
        // 구현 예정
    }

    // 인덱스로 값 읽기
    public int readAt(int index) {
        // 구현 예정
        return -1; // 예시 반환값
    }
}

public class Ch1_ArrayOperationsTemplate {
    public static void main(String[] args) {
        ArrayOperations arrayOperations = new ArrayOperations(10);
    }
}