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
import java.awt.event.ActionListener;

public class Button extends JButton implements IMethod {
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
        return false;
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
    public Component getComponent() {
        return this;
    }

    public void setOnClickListener(ActionListener listener) {
        this.addActionListener(listener);
    }

    @Override
    public void addChild(IMethod child) {
        
    }
}
