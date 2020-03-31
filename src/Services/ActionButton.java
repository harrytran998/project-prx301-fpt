/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Layout.Component.Button;
import Layout.Component.CheckBox;
import Layout.Component.Frame;
import Layout.Component.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author demonslight
 */
public class ActionButton {
    public static void actionWhenCheckButton(Frame frame, Button btn, TextField txtUsername, TextField txtPassword, CheckBox cbx) {
        btn.setOnClickListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean checkUsername = txtUsername.getText().equals("Nhập tên tài khoản");
               boolean checkPassword = txtPassword.getText().equals("Nhập mật khẩu");
               boolean checkSelectedCbx = cbx.isSelected();
               if ( checkUsername|| checkPassword  ) {
                   JOptionPane.showMessageDialog(frame, "Vui lòng nhập Tài khoản và mật khẩu trước", "Ôi xảy ra lỗi", JOptionPane.ERROR_MESSAGE);
               } 
               if (!checkSelectedCbx && !checkPassword && !checkUsername ) {
                   JOptionPane.showMessageDialog(frame, "Hêy, bắt buộc phải chọn thầy đẹp trai hay không nhé!", "Ôi xảy ra lỗi", JOptionPane.ERROR_MESSAGE);
               }
               if (txtUsername.getText().length() != 0 && checkSelectedCbx) {
                    JOptionPane.showMessageDialog(frame, "Tuyệt vời!\r\nVì bạn khen thầy đẹp trai nên suy ra bạn cũng đẹp trai và nhận 10 điểm");
                    System.exit(0);
                }
            }
        });
    }}
