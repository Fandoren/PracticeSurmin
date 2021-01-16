package com.company;

public class Main {

    public static void main(String[] args) {
        //объявление переменных типа byte.
        byte getByte, putByte;
        // инициализация переменных
        getByte = 0;
        putByte = 0;

        //объявление и инициализация переменной типа short.
        short employeeID = 0;

        //объявление и инициализация переменной типа int.
        int max = 2147483647;

        //объявление и инициализация переменной типа float
        float usd = 61.24f;
        float eur = 74.03f;

        //Объявление и инициализация переменных типа double.
        double pi = 3.14159;

        //Объявление и инициализация переменных типа char.
        char symb1=1067;
        char symb2 ='Ы';

        //Объявление и инициализация переменной типа boolean.
        boolean b = true;

        //Создание строки с помощью конструктора
        String myString = new String("The weather was fine");
        //Можно также создать строку используя кавычки ""
        myString = "The weather was fine";

        //NUMBER to STRING
        System.out.println("\n--Преобразование NUMBER to STRING--");
        int i = 35;
        String str = Integer.toString(i);
        System.out.println("Integer to string: " + str);

        double  d = 32.4e10;
        str = Double.toString(i);
        System.out.println("Double to string: " + str);

        long  l = 3422222;
        str = Long.toString(i);
        System.out.println("Long to string: " + str);

        float  f = 3.46f;
        str = Float.toString(i);
        System.out.println("Float to string: " + str);

        //Преобразование CHAR
        System.out.println("\n--Преобразование CHAR--");
        char ch = 'S';

        // c использованием класса Character
        String charToString = Character.toString(ch);
        System.out.println("Char to string: " + charToString);

        // с использованием операции добавления класса String
        str = "" + ch;
        System.out.println("С использованием операции добавления класса String: " + str);

        //с использованием массива
        String fromChar = new String(new char[] { ch });
        System.out.println("С использованием массива: " + fromChar);

        // с использованием метода valueOf класса String
        String valueOfchar = String.valueOf(ch);
        System.out.println("С использованием метода valueOf: " + valueOfchar);

        ch = '9';

        // c использованием метода getNumericValue
        // класса Character
        int i1 = Character.getNumericValue(ch);
        System.out.println("С использованием метода getNumericValue: " + i1);

        // c использованием метода digit класса Character
        int i2 = Character.digit(ch,10);
        System.out.println("С использованием метода digit: " + i2);

        //Преобразование чисел
        System.out.println("\n--Преобразование чисел--");
        i = 2015;
        l = (long) (i);
        System.out.println("INT to LONG: " + l);

        i = 2015;
        f = (float) (i);
        System.out.println("INT to FLOAT: " + f);

        l = 214748364;
        i = (int) l;
        System.out.println("LONG to INT: " + i);

        d = 3.14;
        i = (int) d;
        System.out.println("DOUBLE to INT: " + i);

        System.out.println("--Целочисленные типы--\nbyte, short, int, long, char");
        i=300000;
        System.out.println("\ni = 300000\nУмножение с точностью 32 бита: " + i*i);   // умножение с точностью 32 бита
        long m=i;
        System.out.println("Умножение с точностью 64 бита: " + m*m);   // умножение с точностью 64 бита
        System.out.println("Разность значений int и long: " + (m-i));

        System.out.println("Результат выполнения 1+2+\"text\": " + (1+2)+"text");
        System.out.println("Результат выполнения \"text\"+1+2: " + "text"+1+2);

        System.out.println("Работа с типом CHAR");
        char c='A';
        System.out.println("Результат вывода c:" + c);
        System.out.println("Результат вывода c+1:" + (int)c+1);
        System.out.println("Результат вывода 'c'+'='+c: " + (int)'c'+(int)'='+(int)c);

        System.out.println("--Дробные типы--\n float, double");
        System.out.println("Положительная бесконечность: 1f/0f");
        System.out.println("Положительная бесконечность: -1d/0d");
        System.out.println("NaN: 0.0/0.0");
        System.out.println("NaN: (1.0/0.0)*0.0");
    }
}
