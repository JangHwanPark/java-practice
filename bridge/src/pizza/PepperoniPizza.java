package pizza;

class PepperoniPizza extends Pizza {
    void prepare() {
        System.out.println("페퍼로니 피자 준비");
    }
    void bake() {
        System.out.println("페퍼로니 피자 굽기");
    }
    void cut() {
        System.out.println("페퍼로니 피자 자르기");
    }
    void box() {
        System.out.println("페퍼로니 피자 포장");
    }
}