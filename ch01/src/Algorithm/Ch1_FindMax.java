package src.Algorithm;

public class Ch1_FindMax {
    public static int findMax(int[] array) {
        int max = array[0]; // 배열의 첫 번째 요소를 최대값으로 가정
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i]; // 새로운 최대값 발견
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8, 9, 1};
        System.out.println("Maximum value in the array is: " + findMax(numbers));
    }
}