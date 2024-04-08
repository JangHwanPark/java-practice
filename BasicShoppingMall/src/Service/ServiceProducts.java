package src.Service;
import src.Product.*;

public class ServiceProducts {
    private ProductList productList;

    // 생성자
    public ServiceProducts() {
        this.productList = new ProductList();
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public void initDefaultProducts() {
        ProductList productList = new ProductList();
        setProductList(productList);

        // 상품 생성 및 등록 (Default Value)
        productList.addProduct(new KeyBoard("Samsung", 12000, 50));
        productList.addProduct(new Monitor("LG", 200000, 40));
        productList.addProduct(new MainBoard("Intel", 500000, 20));
        productList.addProduct(new MainBoard("Cmd", 600000, 30));
        productList.addProduct(new KeyBoard("신세계", 5000, 150));
        productList.addProduct(new Monitor("sk", 130000, 40));
        productList.addProduct(new Monitor("Ansan", 130000, 40));

        // Monitor 클래스를 업캐스팅하여 출력하는 GamingMonitor 클래스
        productList.addProduct(new GamingMonitor("LG", 130000, 40, "49", 120, 4, "커브드"));
    }

    // 사용자 입력을 받아 새로운 상품 객체 생성
    public void addProducts(String category, String name, int price, int quantity) {
        switch (category.toLowerCase()) {
            case "keyboard":
                productList.addProduct(new KeyBoard(name, price, quantity));
                break;
            case "monitor":
                productList.addProduct(new Monitor(name, price, quantity));
                break;
            case "mainboard":
                productList.addProduct(new MainBoard(name, price, quantity));
                break;
            default:
                System.out.println("지원하지 않는 상품 카테고리입니다.");
                break;
        }
    }

    // 같은 이름을 쓰지만 오버라이딩 XX
    public iProduct findProductById(int id) {
        return productList.findProductById(id);
    }

    public void showProductList() {
        productList.showProductList();
    }

    public iProduct findItems(int id) {
        return productList.findItems(id);
    }
}