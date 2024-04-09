package src.UpCastingExam01;

class Unit {
    public void attack() {
        System.out.println("유닛 공격");
    }
}

// 유닛을 상속받는 질럿 클래스
class Zealot extends Unit {
    @Override
    public void attack() {
        System.out.println("찌르기");
    }
    
    // 업캐스팅 하면 못쓰는거
    public void teleportation() {
        System.out.println("프로토스 워프");
    }
}

public class UpExam01 {
    public static void main(String[] args) {
        Unit unit_up = new Unit();
        Zealot zealot = new Zealot();
        
        // 업캐스팅 안한 상태
        unit_up.attack();       // 유닛 공격
        zealot.attack();        // 찌르기
        zealot.teleportation(); // 프로토스 워프
        
        // 업캐스팅 실행
        unit_up = (Unit) zealot; // 캐스팅 괄호 생략 가능

        // 멤버 제한됨 (사용 가능한 속성, 함수 감소)
        unit_up.attack(); // 찌르기
    }
}