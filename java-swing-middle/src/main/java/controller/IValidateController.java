package controller;

import models.AdminDTO;

public abstract class IValidateController {
    public IValidateController(AdminDTO userModel) {}

    protected boolean isEmptyUserName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("이름을 입력해주세요.");
            return false;
        }
        return true;
    }

    protected boolean isEmptyPassword(String password) {
        if (password == null || password.isEmpty()) {
            System.out.println("비밀번호를 입력해주세요.");
            return false;
        }
        return true;
    }
}