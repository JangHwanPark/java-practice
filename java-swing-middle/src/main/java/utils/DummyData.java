package utils;

import java.util.Random;

public class DummyData {
    // 중앙 패널 테이블 더미데이터 생성
    public static Object[][] createRandomData(int rows, int columns) {
        Random random = new Random(); // Random 객체 생성
        Object[][] data = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 각 셀에 랜덤한 값을 할당 (Ex. 정수 범위를 0~99로 설정)
                data[i][j] = "Data" + (i+1) + "-" + (j+1) + ": " + random.nextInt(100);
            }
        }

        return data;
    }

    // 테이블 컬럼 제목 생성
    public static String[] createColumnTitles(int columns) {
        String[] columnTitles = new String[columns];
        for (int i = 0; i < columns; i++) {
            columnTitles[i] = "컬럼 " + (i + 1);
        }
        return columnTitles;
    }
}