package idcard;

import framework.Factory;
import framework.Product;

public class IDCardFactory extends Factory {
    // 아이디카드 2000 부터 시작
    static int number = 2000;

    // 추상 클래스 구현
    @Override
    protected Product createProduct(String owner) {
        number++;
        // Factory 클래스의 create 메서드에서 호출됨
        return new IDCard(owner, number);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }

    @Override
    protected void deleteProduct(Product product) {
        System.out.println(product + "을 삭제했습니다.");
    }
}