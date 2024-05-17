package Factory.tv;
import Factory.framework.Product;

public class ModelTV extends Product {
    private String model;
    private int modelNumber;

    // 생성자
    public ModelTV(String model, int modelNumber) {
        this.model = model;
        this.modelNumber = modelNumber;
    }

    @Override
    public void use() {
        System.out.println(this + "브랜드의 TV를 시청합니다..");
    }

    @Override
    public void delete() {
        System.out.println(this + "브랜드의 TV를 버립니다.");
    }

    @Override
    public String toString() {
        return "[ModelTV:" + model +
                ", Model Number: MN" + modelNumber + "]";
    }
}