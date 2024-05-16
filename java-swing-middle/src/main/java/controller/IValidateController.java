package controller;

import models.AdminDTO;
import utils.Constructor;
import utils.Method;

public abstract class IValidateController {
    protected AdminDTO userModel;

    @Constructor
    public IValidateController(AdminDTO userModel) {
        this.userModel = userModel;
    }

    @Method
    protected boolean validateInput(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(fieldName + "을(를) 입력해주세요.");
            return false;
        }
        return true;
    }

    @Method
    protected boolean isEmptyUserName(String name) {
        return validateInput(name, "이름");
    }

    @Method
    protected boolean isEmptyPassword(String password) {
        return validateInput(password, "비밀번호");
    }
}