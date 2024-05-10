package controller;

import models.AdminDTO;
import javax.swing.*;

public class LoginController {
    private AdminDTO userModel;

    public LoginController(AdminDTO userModel) {
        this.userModel = userModel;
    }

    // 사용자 입력 유효성 검사 로직
    private boolean validateUserInput(String password, String email) {
        // 유효성 검사 실패시 경고팝업 출력
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void loginUser(String email, String name) {
        // 임시 테스트 사용자

        AdminDTO testUser = new AdminDTO(1, "Test User", "a1", "123-456-7890", "123 Test Street", "admin");

        if (validateUserInput(email, name)) {
            if (email.equals(testUser.getEmail()) && name.equals("1234")) { // 테스트용 비밀번호
                userModel = testUser;
                JOptionPane.showMessageDialog(null, "로그인 성공!", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "로그인 실패: 이메일 또는 비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}