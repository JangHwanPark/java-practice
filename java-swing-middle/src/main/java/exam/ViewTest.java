package exam;

import dao.ProductDAO;
import models.ProductDTO;

import java.util.List;

public class ViewTest {
    public static void main(String[] args) {
        ProductDAO repository = new ProductDAO();
        List<ProductDTO> lexusCars = repository.getAllModels();
        System.out.println(repository.toString());
        System.out.println(lexusCars);

        // 차량 정보 출력
        if (lexusCars.isEmpty()) {
            System.out.println("데이터베이스에서 자동차를 찾을 수 없습니다.");
        } else {
            for (ProductDTO car : lexusCars) {
                System.out.println(car);
            }
        }
    }
}