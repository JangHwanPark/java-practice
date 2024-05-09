package test;

import models.LexusDTO;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class TestLexus {
    @Test
    public void createLexusInstance() {
        LexusDTO myLexus = new LexusDTO("LX001", "Lexus", "RX350", 2021, "Black", "JTHBK1GG7G2240327");
        LexusDTO lexusES = new LexusDTO("LX002", "Lexus", "ES 300h", 2022, "Silver", "2HGBH41JXMN109187");
        LexusDTO lexusUX = new LexusDTO("LX003", "Lexus", "UX 200", 2023, "Red", "3CGBH41JXMN109188");
        LexusDTO lexusNX = new LexusDTO("LX004", "Lexus", "NX 300h", 2023, "Blue", "4DGBH41JXMN109189");
        LexusDTO lexusLC = new LexusDTO("LX005", "Lexus", "LC 500", 2021, "Black", "5EGBH41JXMN109190");

        // 객체 생성 검증
        String[] models = {"myLexus", "lexusES", "lexusUX", "lexusNX", "lexusLC"};
        for (String model : models) {
            assertNotNull(model+ "객체는 null이 아니어야 합니다.", myLexus);
        }
    }
}