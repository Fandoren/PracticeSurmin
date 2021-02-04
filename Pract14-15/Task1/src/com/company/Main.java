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
            if(word.equals("cross")){
                g.drawLine(0, 0, getWidth(), getHeight());
                g.drawLine(0, getHeight(), getWidth(), 0);
                word = "";
            }
            else if(word.equals("oval")){
                g.drawOval(0, 0, getWidth()-1, getHeight()-1);
                word = "";
            }
            else if(word.equals("step")){
                for (int i=0; i<4; i++) {
                    for (int j=0; j<4; j++) {
                        int c = (int)((i+j)*255/6);
                        g.setColor(new Color(c, c, c));
                        g.fillRect(i*getWidth()/4, j*getHeight()/4, getWidth()/4, getHeight()/4);
                    }
                }
                word = "";
            }
            else if(word.equals("rect")){
                Color c = new Color(
                        (int)(Math.random()*255),
                        (int)(Math.random()*255),
                        (int)(Math.random()*255));
                g.setColor(c);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
            else if(word.equals("q")) {
                g.setClip(null);
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
