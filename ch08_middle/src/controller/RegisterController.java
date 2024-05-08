package src.controller;

import src.models.AdminUserDTO;

import javax.swing.*;

public class RegisterController {
    private final AdminUserDTO userModel;

    // 생성자
    public RegisterController(AdminUserDTO userModel) {
        this.userModel = userModel;
    }

    // 사용자 입력 유효성 검사 로직
    private boolean validateUserInput(String name, String password, String email, String studentId) {
        // 유효성 검사 실패시 경고팝업 출력
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "이름을 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (studentId == null || studentId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void resisterUser(String name, String email, String phone, String address, String role) {
        if (validateUserInput(name, email, phone, address)) {
            userModel.setName(name);
            userModel.setEmail(email);

            userModel.setPhone(phone);
            userModel.setAddress(address);
            userModel.setRole("admin");
        }
    }
}