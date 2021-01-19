package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	    //Задание 1

        System.out.println("\n---Задание 1---\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");

        int number = sc.nextInt();

        System.out.println(number < 100 ? "less": "not less");

        //Задание 2

        System.out.println("\n---Задание 2---\n");
        sc = new Scanner(System.in);
        System.out.println("Введите оценку");

        number = sc.nextInt();

        switch(number)
        {
            case (2):
                System.out.println("Неудовлетворительно");
                break;
            case (3):
                System.out.println("Удовлетворительно");
                break;
            case (4):
                System.out.println("Хорошо");
                break;
            case (5):
                System.out.println("Отлично");
                break;
            default:
                System.out.println("Такой оценки нет");
                break;
        }
        //Задание 3

        System.out.println("\n---Задание 3---\n");
        sc = new Scanner(System.in);
        System.out.println("Введите название дня недели с большой буквы");

        String day = sc.nextLine();

        switch(day)
        {
            case("Воскресенье"):
                System.out.println("0");
                break;
            case("Понедельник"):
                System.out.println("1");
                break;
            case("Вторник"):
                System.out.println("2");
                break;
            case("Среда"):
                System.out.println("3");
                break;
            case("Четверг"):
                System.out.println("4");
                break;
            case("Пятница"):
                System.out.println("5");
                break;
            case("Суббота"):
                System.out.println("6");
                break;
            default:
                System.out.println("День недели введён неверно");
                break;
        }
        //Задание 4

        System.out.println("\n---Задание 4---\n");
        sc = new Scanner(System.in);
        System.out.println("Введите баллы студента");

        number = sc.nextInt();

        if(number > 100)
        {
            System.out.println("Система оценивания стобальная!!!!");
        }
        else
        {
            if(number <= 100 && number > 91) System.out.println("Оценка: A");
            else if(number <= 90 && number > 81) System.out.println("Оценка: B");
            else if(number <= 80 && number > 71) System.out.println("Оценка: C");
            else if(number <= 70 && number > 50) System.out.println("Оценка: D");
            else if(number <= 50) System.out.println("Оценка: F");
        }
        //Задание 5
        System.out.println("\n---Задание 5---\n");
        System.out.println("Номер варианта: " + (10 + 1)%305);

        //Задание 5.1
        System.out.println("\n---Задание 5.1---\n");
        double a = 3.9, b= 4.8, x = 5.17, y = 0;

        y = Main.First(a, b, x);
        System.out.println("1) y = " + y);

        x = -2.35;

        y = Main.First(a, b, x);
        System.out.println("2) y = " + y);
        //Задание 5.2
        System.out.println("\n---Задание 5.2---\n");
        a = 1.7; x = -2.61;

        y = Main.Second(a, x);
        System.out.println("1) y = " + y);

        x = 1.49;

        y = Main.Second(a, x);
        System.out.println("2) y = " + y);

        x = 5.56;

        y = Main.Second(a, x);
        System.out.println("3) y = " + y);
    }

    public static double First(double a, double b, double x)
    {
        if(x > 4)
            return(Math.sqrt(a + Math.abs(Math.sin(x))));
        else
            return(Math.tan(b * x));
    }


    public static double Second(double a, double x)
    {
        if(x > -1 && x <= 4)
            return Math.pow(Math.E, Math.log(Math.pow((x+1), 2))/3);
        else if(x > 4)
            return(1/(x*x + 2));
        else
            return(x * x - a * x);

    }
}
