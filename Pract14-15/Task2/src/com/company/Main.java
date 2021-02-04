package com.company;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Main extends Applet implements ActionListener{

    String colorNames[] = {"Gray","Red","Blue","White"};
    Color colors[] = {Color.gray,Color.red,Color.blue,Color.white};
    PopupMenu pm;
    public void init()
    {
        setBackground(Color.gray);
        pm = new PopupMenu("Фоновый цвет");
        MenuItem colorName;
        for ( int i = 0; i <colorNames.length; i++)
        {
            colorName = new MenuItem(colorNames[i]);
            pm.add(colorName);
            colorName.addActionListener(this);
            pm.addSeparator();
        }
        add(pm);
        MouseListener ml = new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                pm.show(e.getComponent(),e.getX(),e.getY());
            }
        };
        addMouseListener(ml);
    }
    public void actionPerformed(ActionEvent e)
    {
        setBackground(getColor(e.getActionCommand()));
    }
    private Color getColor(String name)
    {
        for ( int i = 0; i <colorNames.length; i++)
        {
            if (colorNames[i].equals(name))
                return colors[i];
        }
        return Color.white;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Пример");
        int width = 800;
        int height = 300;
        Main appl = new Main();
        appl.init();
        frame.getContentPane().add(appl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);
    }
}

