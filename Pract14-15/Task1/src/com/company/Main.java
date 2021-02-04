package com.company;

import java.awt.*;
import java.awt.event.*;

public class Main extends Canvas{

    private int lastX, lastY;
    private int ex, ey;
    private String word = "";
    private boolean clear=false;

    public Main () {
        super();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                ex=e.getX();
                ey=e.getY();
                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()==' ') {
                    clear = true;
                    repaint();
                }
                else{
                    word += e.getKeyChar();
                }
            }
        });
    }

    public void update(Graphics g) {
        if (clear) {
            g.clearRect(0, 0, getWidth(), getHeight());
            clear = false;
        } else if(!word.equals(""))
        {
            if(word.equals("red")){
                g.setColor(Color.red);
                g.drawString(word, ex, ey);
                word = "";
            }
            else if(word.equals("blue")){
                g.setColor(Color.blue);
                g.drawString(word, ex, ey);
                word = "";
            }
            else if(word.equals("black"))
            {
                g.setColor(Color.black);
                g.drawString(word, ex, ey);
                word = "";
            }
            else {
                g.drawString(word, ex, ey);
                word = "";
            }
        }else {
            g.drawLine(lastX, lastY, ex, ey);
            lastX=ex;
            lastY=ey;
        }
    }
    public static void main(String[] s) {
        final Frame f = new Frame("Draw");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.setSize(800, 600);

        final Canvas c = new Main();
        f.add(c);

        f.setVisible(true);
    }
}
