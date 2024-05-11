package view;

import javax.swing.*;

public class DeleteView {
    public DeleteView() {}

    public void DeleteUser() {
        System.out.println("DeleteView 생성자 호출");
        int deleteRes = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (deleteRes == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
        }
    }
}