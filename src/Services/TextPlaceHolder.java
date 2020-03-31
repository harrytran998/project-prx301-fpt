/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Layout.Component.TextField;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author demonslight
 */
public class TextPlaceHolder {

    public static void addTextPlaceHolder(TextField txtFiled, String txtPlaceHolder) {
        txtFiled.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtFiled.getText().equals(txtPlaceHolder)) {
                    txtFiled.setText("");
                    txtFiled.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtFiled.getText().isEmpty()) {
                    txtFiled.setForeground(Color.GRAY);
                    txtFiled.setText(txtPlaceHolder);
                }
            }
        });
    }
}
