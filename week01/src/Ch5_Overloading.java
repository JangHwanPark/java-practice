package src;

abstract class UIComponent {
    public abstract void draw();
}

class Btn extends UIComponent {
    @Override
    public void draw() {
        System.out.println("버튼 생성하기");
    }
}

class Slider extends UIComponent {
    @Override
    public void draw() {
        System.out.println("슬라이더 생성하기");
    }
}

public class Ch5_Overloading {
    public static void main(String[] args) {
        UIComponent btn = new Btn();
        UIComponent slider = new Slider();

        btn.draw();
        slider.draw();
    }
}