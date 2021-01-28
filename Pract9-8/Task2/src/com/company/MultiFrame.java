package com.company;

import java.awt.*;
import java.awt.event.*;
//============================================
// Этот класс действует как окно, в котором отображается апплет,
// когда он запускается как обычное приложение
//============================================
class MultiFrame extends Frame
{
    // Конструктор класса
    //--------------------------------------------------------------------------
    public MultiFrame(String str)
    {	super (str);
        addWindowListener(new MyWindowAdapter());
        // Сделать: Добавьте сюда код конструктора
    }
    class MyWindowAdapter extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            dispose();
            System.exit(0);
        }
    }
}

