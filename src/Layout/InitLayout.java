/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

/**
 *
 * @author demonslight
 */
import Services.Resource;
import Services.XMLParser;
import Layout.Component.Button;
import Layout.Component.CheckBox;
import Layout.Component.Frame;
import Layout.Component.Label;
import Layout.Component.TextField;
import Services.TextPlaceHolder;
import org.w3c.dom.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class InitLayout {

    private static Map<Integer, IMethod> viewList;

    public static IMethod findElementById(int id) {
        if (null == viewList) {
            viewList = new HashMap<>();
        }
        return viewList.get(id);
    }

    public static void addElement(IMethod view) {
        if (null == viewList) {
            viewList = new HashMap<>();
        }
        viewList.put(view.getId(), view);
    }

    public static IMethod initAll(String fileName, IMethod parent) {
        File viewFile = Resource.getResourceFileStream(fileName);

        Element root = XMLParser.getRootElement(viewFile);
        System.out.println(root.getTagName());
        IMethod view = initWindow(root);
        return view;
    }

    private static IMethod initWindow(Element node) {
        IMethod view = null;
        NamedNodeMap attributes = node.getAttributes();
        switch (node.getTagName()) {
            case "Frame":
                view = initFrame(attributes);
                break;
            case "Button":
                view = initButton(attributes);
                break;
            case "TextField":
                view = (IMethod) initTextField(attributes);
                break;
            case "CheckBox":
                view = initCheckBox(attributes);
                break;
            case "Label":
                view = (IMethod) initLabel(attributes);
                break;
            default:
                break;
        }
        if (null != view && view.isContainer()) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node childNode = children.item(i);
                if (childNode instanceof Element) {
                    IMethod child = initWindow((Element) childNode);
                    if (null != child) {
                        view.addChild(child);
                    }
                }
            }
        }
        if (null != view) {
            addElement(view);
        }
        return view;
    }

    private static Frame initFrame(NamedNodeMap attributes) {
        Frame frame = new Frame();
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    frame.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "title":
                    frame.setTitle(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "backColor":
                    frame.setBackground(Color.decode(attr.getValue()));
                    break;
            }
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocation(x, y);
        frame.setSize(width, height);
        return frame;
    }

    public static Button initButton(NamedNodeMap attributes) {
        Button button = new Button();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    button.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    button.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "backColor":
                    button.setBackground(Color.decode(attr.getValue()));
                    break;
                case "fontColor":
                    button.setForeground(Color.decode(attr.getValue()));
                    break;
            }
        }
        button.setLocation(x, y);
        button.setSize(width, height);
        return button;
    }

    public static TextField initTextField(NamedNodeMap attributes) {
        TextField textField = new TextField();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    textField.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    textField.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "placeHolder":
                    TextPlaceHolder.addTextPlaceHolder(textField, attr.getValue());
                    break;
            }
        }
        textField.setSize(width, height);
        textField.setLocation(x, y);
        return textField;
    }

    public static CheckBox initCheckBox(NamedNodeMap attributes) {
        CheckBox checkBox = new CheckBox();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    checkBox.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    checkBox.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "checked":
                    boolean checked = Boolean.parseBoolean(attr.getValue());
                    checkBox.setSelected(checked);
                    break;
            }
        }
        checkBox.setLocation(x, y);
        checkBox.setSize(width, height);
        return checkBox;
    }

    public static Layout.Component.Label initLabel(NamedNodeMap attributes) {
        Layout.Component.Label label = new Label();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        int size = 0;
        Color backColor = null;
        Color fontColor = null;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    label.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    label.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "backColor":
                    backColor = Color.decode(attr.getValue());
                    System.out.println(backColor);

                    break;
                case "fontColor":
                    fontColor = Color.decode(attr.getValue());
                    System.out.println(fontColor);
                    break;
                case "size":
                    size = Integer.parseInt(attr.getValue());
                    break;
            }
        }
        label.setFont(new Font("Serif", Font.PLAIN, size));
        label.setForeground(fontColor);
        label.setBackground(backColor);
        label.setLocation(x, y);
        label.setSize(width, height);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }
}
