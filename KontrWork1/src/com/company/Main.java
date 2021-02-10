package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("-----Задание 1. Работа с консолью-----");
        String result = "";
        System.out.println("\tвариант 3");
        for(int i = 0; i < 5; i++)
        {
            result += "0";
            System.out.println(result);
        }
        System.out.println("\tвариант 5 \n " + (1+2-4));


        System.out.println("-----Задание 2. Простейшая арифметика-----");
        System.out.println("\tвариант 4");
        int a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста, введите ПЕРВОЕ число");
        a = sc.nextInt();
        System.out.println("Пожалуйста, введите ВТОРОЕ число");
        b = sc.nextInt();
        System.out.println("Пожалуйста, введите ТРЕТЬЕ число");
        c = sc.nextInt();
        System.out.println("Среднее арифметическое: " + ((a + b + c) / 3));
        System.out.println("Разность удвоенной суммы первого и третьего числа " +
                "и утроенного второго числа: " + (2*(a + b) - 3 * c ));
        System.out.println("\tвариант 9");
        System.out.println("Пожалуйста, введите температуру в градусах Цельсия число");
        float celsius = sc.nextFloat();
        System.out.println("Температура в градусах Фаренгейта: " + ((9 * celsius) / 5 + 32));


        System.out.println("-----Задание 3. Условный оператор и арифметика-----");
        System.out.println("\tвариант 12");
        System.out.println("Пожалуйста, введите ПЕРВОЕ число");
        a = sc.nextInt();
        System.out.println("Пожалуйста, введите ВТОРОЕ число");
        b = sc.nextInt();
        System.out.println("Пожалуйста, введите ТРЕТЬЕ число");
        c = sc.nextInt();
        if(a > 10 && b > 10 && c > 10 && a % 3 ==0 && b % 3 == 0){
            System.out.println("yes");
        } else{
            System.out.println("no");
        }
        System.out.println("\tвариант 23");
        int initial = Direction.WEST.getCode();
        int command;
        System.out.println("Пожалуйста, введите команду робота");
        command = sc.nextInt();
        //Соревнование на самый глупый способ вывода
        switch (command) {
            case (1) -> {
                initial += 1;
                if (initial == Direction.NORTH.getCode())
                    System.out.println("Робот смотрит на: " + Direction.NORTH.name());
                else if (initial == Direction.WEST.getCode())
                    System.out.println("Робот смотрит на: " + Direction.WEST.name());
                else if (initial == Direction.SOUTH.getCode())
                    System.out.println("Робот смотрит на: " + Direction.SOUTH.name());
                else if (initial == Direction.EAST.getCode())
                    System.out.println("Робот смотрит на: " + Direction.EAST.name());
                else if (initial > Direction.EAST.getCode()) {
                    initial = Direction.NORTH.getCode();
                    System.out.println("Робот смотрит на: " + Direction.NORTH.name());
                }
            }
            case (-1) -> {
                initial -= 1;
                if (initial == Direction.NORTH.getCode())
                    System.out.println("Робот смотрит на: " + Direction.NORTH.name());
                else if (initial == Direction.WEST.getCode())
                    System.out.println("Робот смотрит на: " + Direction.WEST.name());
                else if (initial == Direction.SOUTH.getCode())
                    System.out.println("Робот смотрит на: " + Direction.SOUTH.name());
                else if (initial == Direction.EAST.getCode())
                    System.out.println("Робот смотрит на: " + Direction.EAST.name());
                else if (initial < Direction.NORTH.getCode()) {
                    initial = Direction.EAST.getCode();
                    System.out.println("Робот смотрит на: " + Direction.EAST.name());
                }
            }
            case(0) -> {
                if (initial == Direction.NORTH.getCode())
                    System.out.println("Робот смотрит на: " + Direction.NORTH.name());
                else if (initial == Direction.WEST.getCode())
                    System.out.println("Робот смотрит на: " + Direction.WEST.name());
                else if (initial == Direction.SOUTH.getCode())
                    System.out.println("Робот смотрит на: " + Direction.SOUTH.name());
                else
                    System.out.println("Робот смотрит на: " + Direction.EAST.name());
            }
        }

        System.out.println("-----Задание 4. Циклы и арифметика-----");
        System.out.println("\tвариант 23");
        String buff = "";
        for(int i = 1000; i <= 9999; i++) {
            buff = String.valueOf(i);
            buff = buff.replace('5', ' ');
            buff =buff.replace('6', ' ');
            String[] temp = buff.split(" ");
            buff = "";
            for(int j = 0; j < temp.length; j++)
            {
                buff += temp[j];
            }
            System.out.println(buff);
        }
        System.out.println("\tвариант 54");

        Random random = new Random();
        int sum = 0;
        while (sum <= 10) {
            int rand = random.nextInt(2);
            sum += rand;
            System.out.print(rand);
        }
        System.out.println("\n-----Задание 5. Работа с символами-----");
        System.out.println("\tвариант 2");
        char curChar = 97;
        int newLine = 0;
        do{
            System.out.print(curChar);
            curChar++;
            newLine++;
            if(newLine == 5)
            {
                System.out.print("\n");
                newLine = 0;
            }
        }
        while(curChar <= 'z');
        System.out.println("\n\tвариант 5");
        String[] line;
        line = new String[rnd(3, 10)];
        for(int i = 0; i < line.length; i++)
            line[i] = Character.toString(rnd(97, 122));
        line[rnd(0,line.length - 1)] = "!";
        line[rnd(0,line.length - 1)] = "!";
        System.out.println(arrayToString(line));
    }
    public static String arrayToString(String[] s){
        StringBuilder result = new StringBuilder();
        for (String value : s) result.append(value);
        return result.toString();
    }
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}



enum Direction{
    NORTH(11),
    WEST(12),
    SOUTH(13),
    EAST(14);
    private int code;
    Direction(int code){
        this.code = code;
    }
    public int getCode(){return code;}
}
