package com.company;

import java.io.*;

class Rectangle {
    public int sideA;
    public int sideB;

    public Rectangle(int x, int y) {
        super();
        sideA = x;
        sideB = y;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle))
            return false;
        Rectangle ref = (Rectangle) obj;
        return (((this.sideA == ref.sideA) && (this.sideB == ref.sideB)) ||
                (this.sideA == ref.sideB) && (this.sideB == ref.sideA));
    }
}

class Book {
    private String title;
    private String author;
    private int pagesNumber;

    public Book(String title, String author,
                int pagesNumber) {
        super();
        this.title = title;
        this.author = author;
        this.pagesNumber = pagesNumber;
    }
    public String toString(){
        return "Book: " + title + " ( " + author +
                ", " + pagesNumber + " pages )";
    }
}

interface Vehicle {
    void go();
}
class Automobile implements Vehicle {
    public void go() {
        System.out.println("Automobile go!");
    }
}
class Truck implements Vehicle {
    public Truck(int i) {
        super();
    }
    public void go() {
        System.out.println("Truck go!");
    }
}

class Test {
    public Test() {
    }

    void doTest(StringBuffer theSb){
        theSb.append("-bbb");
    }
}

public class Main {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10,20);
        Rectangle r2 = new Rectangle(10,10);
        Rectangle r3 = new Rectangle(20,10);
        System.out.println("r1.equals(r1) == " + r1.equals(r1));
        System.out.println("r1.equals(r2) == " + r1.equals(r2));
        System.out.println("r1.equals(r3) == " + r1.equals(r3));
        System.out.println("r2.equals(r3) == " + r2.equals(r3));
        System.out.println("r1.equals(null) == " + r1.equals(null));

        System.out.println();

        Book book = new Book("Java2","Sun",1000);
        System.out.println("object is: " + book);

        System.out.println();

        Vehicle vehicle;
        String[] vehicleNames = {"demo.lang.Automobile",
                "demo.lang.Truck", "demo.lang.Tank"};
        for(int i=0; i<vehicleNames.length; i++) {
            try {
                String name = vehicleNames[i];
                System.out.println("look for class for: " + name);
                Class aClass = Class.forName(name);
                System.out.println("creating vehicle...");
                vehicle = (Vehicle)aClass.newInstance();
                System.out.println("create vehicle: " + vehicle.getClass());
                vehicle.go();
            } catch(ClassNotFoundException e) {
                System.out.println("Exception: " + e);
            } catch(InstantiationException | IllegalAccessException e) {
                System.out.println("Exception: " + e);
            }
        }

        System.out.println();

        int i = 1;
        byte b = 1;
        String value = "1000";
        Integer iObj = new Integer(i);
        Byte bObj = new Byte(b);
        System.out.println("while i==b is " +
                (i==b));
        System.out.println("iObj.equals(bObj) is "
                + iObj.equals(bObj));
        Long lObj = new Long(value);
        System.out.println("lObj = " +
                lObj.toString());
        Long sum = new Long(lObj.longValue() +
                iObj.byteValue() +
                bObj.shortValue());
        System.out.println("The sum = " +
                sum.doubleValue());

        System.out.println();

        Test t = new Test();
        String s1 = "Hello world !!!";
        String s2 = new String("Hello world !!!");
        System.out.println("String`s equally = " +
                (s1.equals(s2)));
        System.out.println(
                "Strings are the same = " + (s1==s2));

        System.out.println();

        t = new Test();
        String s = "prefix !";
        System.out.println(s);
        s = s.trim();
        System.out.println(s);
        s = s.concat(" suffix");
        System.out.println(s);

        System.out.println();

        t = new Test();
        StringBuffer sb = new StringBuffer("aaa");
        System.out.println("Before = " + sb);
        t.doTest(sb);
        System.out.println("After = " + sb);

        System.out.println();

        System.out.println("Study Java");
        try {
            PrintStream print = new PrintStream(new
                    FileOutputStream("d:\\file2.txt"));
            System.setOut(print);
            System.out.println("Study well");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
