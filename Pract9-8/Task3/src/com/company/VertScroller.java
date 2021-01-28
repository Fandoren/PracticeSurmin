package com.company;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class VertScroller extends Applet implements Runnable, ActionListener{
    String strs[]={"First string", "Second string", "Third string"};
    // текущий размер окна апплета
    private Vector strings;
    private int count = 0;
    private int height;
    private int width;
    private Button startButton, stopButton;
    private Thread animated;
    public void update(Graphics g)
    {
        paint(g);
    }
    public void init()
    {
        strings = new Vector();
        setBackground(Color.BLACK);
        height = getSize().height;
        width = getSize().width;
        startButton = new Button("Начало движения");
        startButton.addActionListener(this);
        add(startButton);
        stopButton = new Button("Останов движения");
        stopButton.addActionListener(this);
        add(stopButton);
    }
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource()==startButton)
        { if(strings.size() == 0 )
        {
            getGraphics().clearRect(0,0,width,height);
            animated = new Thread(this);
            animated.start();
        }
            int x = randomInt(width/2);
            int y = randomInt(height/2);
            int deltax = 1+randomInt(10);
            int deltay = 1+randomInt(10);
            if(count<strs.length)
            {
                strings.addElement(new MyString("Ещё какая-то строка!",x,y,deltax,deltay));
            }
            else
            {
                strings.addElement(new MyString("Прикольная строка, вау",x,y,deltax,deltay));
            }
        }
        else
        if(e.getSource()==stopButton)
        {
            strings.removeAllElements();
            animated = null;
            count = 0;
        }
        repaint();
    }

    private int randomInt(int max) {
        double x = Math.floor((double)(max+1)*Math.random()) ;
        return (int)(Math.round(x));
    }

    public void run()
    {
        Thread my = Thread.currentThread();
        while (my == animated)
        { repaint();
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            { }
        }
    }
    public void paint(Graphics g)
    {
        MyString str;
        for ( int i = 0; i < strings.size(); i++)
        {
            str =(MyString) strings.elementAt(i);
            g.setColor(getBackground());
            str.draw(g);
            str.move(width,height);
            g.setColor(Color.BLACK);
            g.setColor(getForeground());
            str.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame ("SurminApp");
        int width = 800;
        int height = 300;
        VertScroller appl = new VertScroller ();
        appl.init();
        frame.getContentPane().add(appl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);
    }
}
