import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

class MyFrame extends Frame{
    static int left = 100;
    static int top = 200, bottom = 200, right = 200;

    MyFrame(String name){
        super(name);
    }

    public void paint(Graphics g){
        g.drawLine(left,top,right,bottom);
    }

    public void MoveLeft(){
        if(left >= 0) {
            left -= 10;
            right -= 10;
        }
        else{
            right = 400;
            left = 300;
        }
        this.repaint();
    }
    public void MoveRight(){
        if(right <= 400) {
            left += 10;
            right += 10;
        }
        else{
            right = 100;
            left = 0;
        }

        this.repaint();
    }
    public void MoveBot(){
        if(top <= 400) {
            top += 10;
            bottom += 10;
        }
        else{
            top = 30;
            bottom = 30;
        }
        this.repaint();
    }
    public void MoveTop(){
        if(top >= 0) {
            top -= 10;
            bottom -= 10;
        }
        else{
            top = 400;
            bottom = 400;
        }

        this.repaint();
    }
}

public class Main extends Applet{

    int top;
    int bot;
    int left;
    int right;
    MyFrame fr;


    public void init(){
        Button up = new Button();
        up.setLabel("UP");
        up.setSize(50,50);
        up.setLocation(50,25);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.MoveTop();
            }
        });

        Button down = new Button();
        down.setLabel("DOWN");
        down.setSize(50,50);
        down.setLocation(50,75);
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.MoveBot();
            }
        });

        Button left = new Button();
        left.setLabel("LEFT");
        left.setSize(50,50);
        left.setLocation(0,50);
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.MoveLeft();
            }
        });

        Button right = new Button();
        right.setLabel("RIGHT");
        right.setSize(50,50);
        right.setLocation(100,50);
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.MoveRight();
            }
        });

        Button blank = new Button();
        blank.setVisible(false);

        fr= new MyFrame("SurminAG");
        fr.setSize(400, 400);
        fr.setVisible(true);
        fr.add(up);
        fr.add(down);
        fr.add(left);
        fr.add(right);
        fr.add(blank);

        fr.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                fr.dispose();
            }
        });



    }
}
