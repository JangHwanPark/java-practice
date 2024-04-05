package src.Product;

/**
 * {@link MainBoard} - {@link iProduct}추상 클래스를 상속받은 구현 클래스입니다.<br>
 * Todo MainBoard 작성중 */
public class MainBoard extends iProduct {
    private String cpu;
    private String memory;
    private String disk;

    /** Todo MainBoard 작성 */
    public MainBoard(String maker, int totalquantity, int price) {
        setMaker(maker);
        setKind("MAINBOARD");
        setPrice(price);
        setTotalquantity(totalquantity);
        cpu = "i6";
    }

    // Getter
    public String getCpu() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getDisk() {
        return disk;
    }

    // Setter
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    // View
    public void showitem() {
        System.out.println(kind + ":" + maker + ":" + totalquantity + ":" + price + " cpu : " + cpu);
    }
}