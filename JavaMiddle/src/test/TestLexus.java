package test;

import models.ProductDTO;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class TestLexus {
    @Test
    public void createLexusInstance() {
        ProductDTO myLexus = new ProductDTO(1, "Lexus", "RX350", 2021, "Black", "JTHBK1GG7G2240327", 100000);
        ProductDTO lexusES = new ProductDTO(2, "Lexus", "ES 300h", 2022, "Silver", "2HGBH41JXMN109187", 200000);
        ProductDTO lexusUX = new ProductDTO(3, "Lexus", "UX 200", 2023, "Red", "3CGBH41JXMN109188", 300000);
        ProductDTO lexusNX = new ProductDTO(4, "Lexus", "NX 300h", 2023, "Blue", "4DGBH41JXMN109189", 400000);
        ProductDTO lexusLC = new ProductDTO(5, "Lexus", "LC 500", 2021, "Black", "5EGBH41JXMN109190", 5100000);

        // 객체 생성 검증
        String[] models = {"myLexus", "lexusES", "lexusUX", "lexusNX", "lexusLC"};
        for (String model : models) {
            assertNotNull(model+ "객체는 null이 아니어야 합니다.", myLexus);
        }
    }
}