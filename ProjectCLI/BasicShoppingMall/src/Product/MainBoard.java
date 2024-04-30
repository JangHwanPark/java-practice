package src.Product;

/**
 * {@link MainBoard} - {@link iProduct}추상 클래스를 상속받아 구현됩니다.<br>
 * 이 클래스는 메인보드에 대한 정보를 출력하며, CPU, RAM, 디스크 등, 하드웨어 상품을 관리합니다.
 */
public class MainBoard extends iProduct {
    private String cpu;
    private String memory;
    private String disk;

    /**
     * MainBoard 객체의 생성자입니다.
     *
     * @param maker 메인보드 제조사
     * @param totalQuantity 총 수량
     * @param price 가격
     */
    public MainBoard(String maker, int totalQuantity, int price) {
        setMaker(maker);
        setKind("MAINBOARD");
        setPrice(price);
        setTotalQuantity(totalQuantity);
        cpu = "i6"; // set default cpu
    }

    // Getter
    /**
     * CPU 정보를 가져옵니다.
     *
     * @return CPU 사양 문자열
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * 메모리 정보를 가져옵니다.
     *
     * @return 메모리 사양 문자열
     */
    public String getMemory() {
        return memory;
    }

    /**
     * 디스크 정보를 가져옵니다.
     *
     * @return 디스크 사양 문자열
     */
    public String getDisk() {
        return disk;
    }

    // Setter
    /**
     * CPU 정보를 설정합니다.
     *
     * @param cpu 설정할 CPU 사양
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * 메모리 정보를 설정합니다.
     *
     * @param memory 설정할 메모리 사양
     */
    public void setMemory(String memory) {
        this.memory = memory;
    }

    /**
     * 디스크 정보를 설정합니다.
     *
     * @param disk 설정할 디스크 사양
     */
    public void setDisk(String disk) {
        this.disk = disk;
    }

    // View
    public void showItem() {
        System.out.println("==== MainBoard Information ====");
        System.out.println("Maker: " + maker);
        System.out.println("Type: " + kind);
        System.out.println("Quantity: " + totalQuantity);
        System.out.println("Price: " + price);
        System.out.println("CPU: " + cpu);

        // 메모리, 디스크 정보가 설정되었는지 확인 후 표시
        if (memory != null && !memory.isEmpty()) {
            System.out.println("Memory: " + memory);
        }

        if (disk != null && !disk.isEmpty()) {
            System.out.println("Disk: " + disk);
        }
        System.out.println("===============================");
    }
}