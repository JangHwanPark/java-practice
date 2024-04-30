package src.Product;

/**
 * {@link Monitor} 클래스를 상속받아 구현된 게이밍 모니터 클래스입니다.<br>
 * 게이밍에 최적화된 특성(주사율, 응답 속도, 패널 형태)을 추가적으로 정의합니다.
 */
public class GamingMonitor extends Monitor {
    private int refreshRate; // 최대 주사율 (Hz)
    private int resSpeed; // 응답 속도 (ms)
    private String panelForm; // 패널 형태 (예: 평면, 커브드)

    /**
     * GamingMonitor 객체의 생성자입니다.<br>
     * 게이밍 모니터의 상세 사양을 초기화합니다.
     *
     * @param maker         제조사
     * @param totalQuantity 총 수량
     * @param price         가격
     * @param size          모니터의 크기 (예: "27인치")
     * @param type          모니터의 유형 (예: "LED")
     * @param refreshRate   최대 주사율 (Hz)
     * @param resSpeed      응답 속도 (ms)
     * @param panelForm     패널 형태 (예: "평면", "커브드")
     */
    public GamingMonitor(String maker, int totalQuantity, int price, String size, int refreshRate, int resSpeed, String panelForm) {
        super(maker, totalQuantity, price);
        setSize(size);
        this.refreshRate = refreshRate;
        this.resSpeed = resSpeed;
        this.panelForm = panelForm;
    }

    // Getter - 사용자로부터 입력받은 값을 반환함 (View 에서 출력함)
    public int getRefreshRate() {
        return refreshRate;
    }

    public int getResSpeed() {
        return resSpeed;
    }

    public String getPanelForm() {
        return panelForm;
    }

    // Setter - 입력받은 값이 refreshRate 변수에 저장되고 생성자로 전달됨
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setResSpeed(int resSpeed) {
        this.resSpeed = resSpeed;
    }

    public void setPanelForm(String panelForm) {
        this.panelForm = panelForm;
    }

    // View
    // 부모 클래스(Monitor)의 showItem() 메서드를 오버라이드하여 추가 정보를 출력합니다.
    @Override
    public void showItem() {
        super.showItem();
        System.out.println("Refresh Rate: " + refreshRate + "Hz");
        System.out.println("Response Speed: " + resSpeed + "ms");
        System.out.println("Panel Form: " + panelForm);
        System.out.println("=============================");
    }
}