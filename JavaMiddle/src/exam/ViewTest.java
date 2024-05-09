package exam;

import models.LexusDAO;
import models.LexusDTO;

import java.util.List;

public class ViewTest {
    public static void main(String[] args) {
        LexusDAO repository = new LexusDAO();
        List<LexusDTO> lexusCars = repository.getAllLexus();

        for (LexusDTO car : lexusCars) {
            System.out.println(car);
        }
    }
}