package src.Service;

import src.Shopping.User;
import src.Utils.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class ServiceUser {  // 비즈니스로직 - 사용자 등록, 로그인
    private User currentUser;
    private final List<User> users = new ArrayList<>();

    // Test: 테스트 사용자
    public ServiceUser() {
        addUser(new User("kim", "1234"));
    }

    // Note: User Getter, Setter
    public User getUser(int id) { // 사용자 조회
        return users.get(id);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setUser(User user) {
        this.users.add(user);
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    // Note: Auth
    // Fixme: 추후 주소, 폰번 추가
    public boolean createUser(String uid, String password) { // 회원 가입
        for (User user : users) { // 아이디 중복 검사
            if (user.getUserId().equals(uid)) {
                System.out.println("이미 사용중인 아이디 입니다.");
                return false;
            }
        }

        // setUser 메서드를 통해 리스트에 사용자 객체 추가
        User newUser = new User(uid, password);
        setUser(newUser);
        System.out.println("회원가입이 완료되었습니다.");
        return true;
    }
    
    public boolean signInUser(String uid, String password) { // 로그인
        for (User user : users) {
            if (user.getUserId().equals(uid) && user.getPassword().equals(password)) {
                setCurrentUser(user); // 사용자 정보 일치 시, 현재 사용자로 설정
                return true;
            }
        }
        return false;
    }

    // Note: Find
    /**
     * @param index 사용자 목록에서의 위치를 나타내는 인덱스
     * @return 선택된 사용자 객체. 인덱스가 범위를 벗어난 경우, IndexOutOfBoundsException을 발생시킬 수 있습니다.
     */
    public User findUserById(int index) { // 사용자 목록에서 인덱스에 해당하는 사용자를 선택
        // 인덱스 유효성 검사
        if (index >= 0 && index < users.size()) {
            currentUser = users.get(index);
            System.out.println("선택 인덱스: " + currentUser.getUserId()); // Debuglog
            return currentUser;
        } else {
            System.out.println("없는 인덱스: " + index); // Debuglog
            return null;
        }
    }

    /**
     * @param id 사용자의 고유 식별자(ID)를 나타내는 문자열
     * @return 해당 ID를 가진 사용자 객체. 해당 ID의 사용자가 목록에 없을 경우 null을 반환합니다.
     */
    public User findUserById(String id) { // 사용자 id로 사용자 목록에서 사용자를 찾아 반환
        for (User user : users) {
            if (id.equals(user.getUserId())) return user;
        }
        return null;
    }

    // Test
    public void addUser(User user) {
        users.add(user);
    }
}