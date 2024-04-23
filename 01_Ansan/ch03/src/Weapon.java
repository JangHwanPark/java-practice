class Weapon1 {
    protected int fire() {
        return 1;
    }
}

class Cannon extends Weapon1 {
    @Override
    protected int fire() {
        return 1000;
    }
}

public class Weapon {
    public static void main(String[] args) {
        Weapon1 w1 = new Weapon1();
        System.out.println("Weapon1 : " + w1.fire());

        Cannon c = new Cannon();
        System.out.println("Cannon : " + c.fire());
    }
}
