package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BufferedReaderInput {

}

public class Java_BufferedReaderInput {
    public static void main(String[] args) throws IOException {
        // BufferedReader Input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("======== BufferedReader Input ========");
        System.out.println("이름을 입력하세요.");
        String bufferedName = bufferedReader.readLine();

        System.out.println("나이를 입력하세요.");
        int bufferedAge = Integer.parseInt(bufferedReader.readLine());

        bufferedReader.close();
        System.out.println("이름(name): " + bufferedName);
        System.out.println("나이(age): " + bufferedAge);
    }
}