package src.controller;

import src.models.AdminUserDTO;

import javax.swing.*;

public class LoginController {
    private final AdminUserDTO userModel;

    public LoginController(AdminUserDTO userModel) {
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
        if (validateUserInput(name, email)) {
            userModel.setEmail(email);
            userModel.setName(name);
        }
    }
}