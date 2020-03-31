/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout.Component;

/**
 *
 * @author demonslight
 */
import Layout.IMethod;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel implements IMethod {
    private int id;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isContainer() {
        return true;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
    }


    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addChild(IMethod child) {
    }

    @Override
    public Component getComponent() {
        return this;
    }
}
