/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import java.awt.Component;

/**
 *
 * @author demonslight
 */


public interface IMethod {
    public int getId();
    public void setId(int id);
    public boolean isContainer();
    public void setLocation(int x, int y);
    public void setSize(int width, int height);
    public void addChild(IMethod child);
    public Component getComponent();
}
