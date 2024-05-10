package controller;

import models.AdminDTO;
import javax.swing.*;

public class RegisterController extends IValidateController {
    private AdminDTO userModel;

    // 생성자
    public RegisterController(AdminDTO userModel) {
        super(userModel);
        this.userModel = userModel;
    }

    // 사용자 입력 유효성 검사 로직
    protected boolean isEmptyUserEmail(String email) {
        return email != null && !email.isEmpty();
    }

    protected boolean isEmptyUserNumber(String studentId) {
        return studentId != null && !studentId.isEmpty();
    }

    public boolean validate(String name, String email, String phone, String address, String password) {
        if (!isEmptyUserName(name)) {
            System.out.println("유효하지 않은 이름: 이름을 입력해주세요.");
            return false;
        }
        if (!isEmptyPassword(phone)) { // 예제 코드에서 전화번호를 비밀번호 검증 메소드로 검증하고 있었습니다. 이는 수정이 필요할 수 있습니다.
            System.out.println("유효하지 않은 전화번호: 전화번호를 입력해주세요.");
            return false;
        }
        if (!isEmptyUserEmail(email)) {
            System.out.println("유효하지 않은 이메일: 이메일을 입력해주세요.");
            return false;
        }
        if (!isEmptyUserNumber(password)) {
            System.out.println("유효하지 않은 비밀번호: 비밀번호를 입력해주세요.");
            return false;
        }
        if (address.isEmpty()) {
            System.out.println("유효하지 않은 주소: 주소를 입력해주세요.");
            return false;
        }
        return true; // 모든 검증이 통과되면 true 반환
    }

    public void registerUser(String name, String email, String phone, String address, String password, String role) {
        if (validate(name, email, phone, address, password)) {
            userModel.setName(name);
            userModel.setEmail(email);
            userModel.setPhone(phone);
            userModel.setAddress(address);
            userModel.setRole(role);
            System.out.println("사용자 등록이 성공적으로 완료되었습니다.");
        } else {
            System.out.println("사용자 등록에 실패했습니다. 입력 정보를 확인해주세요.");
        }
    }
}