package pizza;

class CheesePizza extends Pizza {
    void prepare() {
        System.out.println("치즈 피자 준비");
    }
    void bake() {
        System.out.println("치즈 피자 굽기");
    }
    void cut() {
        System.out.println("치즈 피자 자르기");
    }
    void box() {
        System.out.println("치즈 피자 포장");
    }
}