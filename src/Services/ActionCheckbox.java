/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Layout.Component.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author demonslight
 */
public class ActionCheckbox {
    public static void actionCheckboxPerformed(JCheckBox checkbox, Frame frame) {
        checkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Quả thật là 1 lựa chọn sáng suốt!");
                }
            }
        });
    }
}
