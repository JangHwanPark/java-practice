package src;

import java.text.MessageFormat;

class MultiAttributes {
    int id = 9086;
    String name = "문자열";
    int solved = 38000;
    int average_attempt = 3;

    public void PrintAttributes() {
        System.out.println("문제번호: " + id + ", 문제이름: " + name + ", 해결한사람: " + solved + ", 평균시도: "+ average_attempt +"");
    }

    public void StringFormat() {
        String formatMessage = String.format("문제번호: %d, 문제이름: %s, 해결한사람: %d, 평균시도: %d", id, name, solved,
                average_attempt);
        System.out.println(formatMessage);
    }

    public void MessageFormat() {
        String pattern = "문제번호: {0}, 문제이름: {1}, 해결한사람: {2}, 평균시도:{3}";
        String message = MessageFormat.format(pattern, id, name, solved, average_attempt);
        System.out.println(message);
    }
}

public class Ch1CreateAnObject {
    int x = 5;

    // final : 재정의 불가
    final int notChange = 10;

    public static void main(String[] args) {
        Ch1CreateAnObject newObj1 = new Ch1CreateAnObject();
        Ch1CreateAnObject newObj2 = new Ch1CreateAnObject();
        System.out.println("CreateAnObject: " + newObj1.x);
        System.out.println("CreateAnObject: " + newObj2.x);

        // Modify Attributes
        int sumObj = newObj1.x + newObj2.x;
        System.out.println("sumObj: " + sumObj);

        newObj1.x = 25;
        int sumObj2 = newObj1.x + newObj2.x;
        System.out.println("sumObj2: " + sumObj2);

        // error
        Ch1CreateAnObject notChangeObj = new Ch1CreateAnObject();
        /*notChangeObj.notChange = 25;
        System.out.println(notChangeObj.notChange);*/

        // true
        notChangeObj.x = 25;
        System.out.println("notChangeObj.x: " + notChangeObj.x);

        // Create MultiAttributes
        MultiAttributes multiAttributes = new MultiAttributes();
        multiAttributes.PrintAttributes();
        multiAttributes.StringFormat();
        multiAttributes.MessageFormat();
    }
}