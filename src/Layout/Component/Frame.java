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
import java.util.HashMap;
import java.util.Map;

public class Frame extends JFrame implements IMethod {
    private final Map<Integer, IMethod> childList;
    private int id;

    public Frame() {
        this.childList = new HashMap<>();
    }

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
    public Component getComponent() {
        return this;
    }

    @Override
    public void addChild(IMethod child) {
        this.add(child.getComponent());
        this.childList.put(child.getId(), child); //To change body of generated methods, choose Tools | Templates.
    }
}
