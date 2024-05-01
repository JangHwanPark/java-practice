package src.test;

import org.junit.Test;
import src.models.Lexus;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class TestLexus {
    @Test
    public void createLexusInstance() {
        Lexus myLexus = new Lexus("LX001", "Lexus", "RX350", 2021, "Black", "JTHBK1GG7G2240327");
        Lexus lexusES = new Lexus("LX002", "Lexus", "ES 300h", 2022, "Silver", "2HGBH41JXMN109187");
        Lexus lexusUX = new Lexus("LX003", "Lexus", "UX 200", 2023, "Red", "3CGBH41JXMN109188");
        Lexus lexusNX = new Lexus("LX004", "Lexus", "NX 300h", 2023, "Blue", "4DGBH41JXMN109189");
        Lexus lexusLC = new Lexus("LX005", "Lexus", "LC 500", 2021, "Black", "5EGBH41JXMN109190");

        // 객체 생성 검증
        String[] models = {"myLexus", "lexusES", "lexusUX", "lexusNX", "lexusLC"};
        for (String model : models) {
            assertNotNull(model+ "객체는 null이 아니어야 합니다.", myLexus);
        }
    }
}