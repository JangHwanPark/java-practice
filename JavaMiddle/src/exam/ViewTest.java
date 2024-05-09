package exam;

import dao.LexusDAO;
import models.LexusDTO;

import java.util.List;

public class ViewTest {
    public static void main(String[] args) {
        LexusDAO repository = new LexusDAO();
        List<LexusDTO> lexusCars = repository.getAllLexus();
        System.out.println(repository.toString());
        System.out.println(lexusCars);

        // 차량 정보 출력
        if (lexusCars.isEmpty()) {
            System.out.println("데이터베이스에서 자동차를 찾을 수 없습니다.");
        } else {
            for (LexusDTO car : lexusCars) {
                System.out.println(car);
            }
        }
    }
}