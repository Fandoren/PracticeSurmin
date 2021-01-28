package com.company;

import java.awt.*;

public class MyString extends Object // класс для реализации строк
{
    int x,y,deltax,deltay;
    String str;
    public MyString(String str, int x, int y, int deltax, int deltay) {
        this.x = x;
        this.y = y;
        this.deltax = deltax;
        this.deltay = deltay;
        this.str = str;
    }

    public void draw(Graphics g) {
        g.drawString(str,x,y);
    }

    public void move(int width, int height) {
        x = x+ deltax;
        y = y+deltay;
    }
}
