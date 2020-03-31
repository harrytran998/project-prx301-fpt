/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author demonslight
 */


import Layout.Component.Button;
import Layout.Component.CheckBox;
import Layout.Component.Frame;
import Layout.Component.TextField;
import Layout.InitLayout;
import Services.ActionButton;
import Services.ActionCheckbox;


public class InitLayOut {
    private final Frame mainFrame;
    private final TextField txtUsername;
    private final TextField txtPassword;
    private final CheckBox cbxHandsome;
    private final Button btnCheck;

    public static void main(String[] args) {
        InitLayOut loadLayout = new InitLayOut();
    }

    public InitLayOut() {
        mainFrame = (Frame) InitLayout.initAll("Layout", null);
        mainFrame.setVisible(true);
        
        // 3 - 5 - 7 - 8 là ID đã định nghĩa trong file XML
        txtUsername = (TextField) InitLayout.findElementById(3);
        txtPassword = (TextField) InitLayout.findElementById(5);
        cbxHandsome = (CheckBox) InitLayout.findElementById(7);
        btnCheck = (Button) InitLayout.findElementById(8);
        
        ActionCheckbox.actionCheckboxPerformed(cbxHandsome, mainFrame);
        ActionButton.actionWhenCheckButton(mainFrame, btnCheck, txtUsername, txtPassword, cbxHandsome);
    }
}
