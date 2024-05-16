package controller;

import dao.AdminDAO;
import models.AdminDTO;
import utils.Constructor;
import utils.Method;
import view.AdminView;

import javax.swing.*;

public class AuthController extends IValidateController {
    private AdminDTO userModel;
    private final AdminDAO adminDAO;

    @Constructor("생성자")
    public AuthController(AdminDTO userModel) {
        super(userModel);
        this.userModel = userModel;
        this.adminDAO = new AdminDAO();
    }

    @Constructor("생성자")
    public AuthController(String email, String password) {
        super(null);
        this.adminDAO = new AdminDAO();
    }

    @Method("현재 로그인된 사용자 정보 가져오기")
    public AdminDTO getUserModel() {
        return userModel;
    }

    @Method("사용자 입력 유효성 검사 로직")
    private boolean validateUserInput(String password, String email) {
        // 유효성 검사 실패시 경고팝업 출력
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "이메일을 입력해주세요.",
                    "입력 오류",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "비밀번호를 입력해주세요.",
                    "입력 오류",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }

    @Method("사용자 로그인 로직")
    public void loginUser(String email, String password) {
        if (validateUserInput(email, password)) {
            AdminDTO userFromDb = adminDAO.selectLoginUser(email, password);
            System.out.println("사용자 로그인 로직: " + email + ", " + password);

            if (userFromDb != null) {
                JOptionPane.showMessageDialog(
                        null,
                        "로그인 성공, 관리자 뷰로 전환합니다.",
                        "로그인 성공",
                        JOptionPane.INFORMATION_MESSAGE
                );

                this.userModel = userFromDb;
                AdminView adminView = AdminView.getInstance();
                adminView.createTableData();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "로그인 실패: 이메일 또는 비밀번호가 잘못되었습니다.",
                        "로그인 실패",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    @Method("사용자 입력 유효성 검사 로직")
    protected boolean isEmptyUserEmail(String email) {
        return email != null && !email.isEmpty();
    }

    @Method("사용자 입력 유효성 검사 로직")
    protected boolean isEmptyUserNumber(String studentId) {
        return studentId != null && !studentId.isEmpty();
    }

    @Method
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
        return true;
    }

    @Method
    public void registerUser(String name, String email, String phone, String address, String password, String role) {
        if (validate(name, email, phone, address, password)) {
            userModel.setName(name);
            userModel.setEmail(email);
            userModel.setPhone(phone);
            userModel.setAddress(address);
            userModel.setRole(role);
            JOptionPane.showMessageDialog(null, "사용자 등록이 성공적으로 완료되었습니다.");
        } else {
            JOptionPane.showMessageDialog(null, "사용자 등록에 실패했습니다. 입력 정보를 확인해주세요.");
        }
    }
}