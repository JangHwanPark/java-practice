package controller;

import dao.AdminDAO;
import models.AdminDTO;
import utils.Constructor;
import utils.Method;
import view.AdminView;

import javax.swing.*;

public class LoginController extends IValidateController {
    private AdminDTO userModel;
    private AdminDAO adminDAO;

    @Constructor
    public LoginController(AdminDTO userModel) {
        super(userModel);
        this.userModel = userModel;
        this.adminDAO = new AdminDAO();
    }

    @Constructor
    public LoginController(String email, String password) {
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
}