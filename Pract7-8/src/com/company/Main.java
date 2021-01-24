package com.company;

import Exercise3.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n--------Задание 1--------\n");
        System.out.println("\n--Создание объекта Book, который реализует интерфейс Printables--");
        Printables Printables = new Book("Java. Complete Reference", "H. Shildt");
        Printables.print();      //  Java. Complete Reference (H. Shildt)
        System.out.println("\n--Создание объекта Journal заместо объекта Book у той же ссылочной переменной. Journal так же реализует Printables--");
        Printables = new Journal("Foreign Policy");
        Printables.print();      // Foreign Policy

        System.out.println("\n--В результате работы метода createPrintables возвращается объект Printables--");
        Printables = createPrintables("Foreign Affairs",false);
        Printables.print();

        System.out.println("\n--В качестве параметров метода передаются объекты Printables(т.е. могут передаваться объекты Book и Journal)--");
        read(new Book("Java for impatients", "Cay Horstmann"));
        read(new Journal("Java Dayly News"));

        System.out.println("\n--Демонстрация работы приватных методов по умолчанию в интерфейсе.--");
        Calculatable c = new Calculation();
        System.out.println(c.sum(1, 2));
        System.out.println(c.sum(1, 2, 4));

        System.out.println("\n--Демонстрация констант в интерфейсах.--");
        WaterPipe pipe = new WaterPipe();
        pipe.printState(1);


        System.out.println("\n--Демонстрация работы функций обратного вызова(функция передаются в качестве параметра)--");
        Button tvButton = new Button(new EventHandler(){

            private boolean on = false;
            public void execute(){

                if(on) {
                    System.out.println("Телевизор выключен..");
                    on=false;
                }
                else {
                    System.out.println("Телевизор включен!");
                    on=true;
                }
            }
        });

        Button printButton = new Button(new EventHandler(){

            public void execute(){

                System.out.println("Запущена печать на принтере...");
            }
        });

        tvButton.click();
        printButton.click();
        tvButton.click();

        System.out.println("\n--------Задание 3--------\n");
        System.out.println("\n--Создание экземпляров класса Car. Класс Car реализует интерфейс Printable и его метод println()--");

        Car c1 = new Car("Mercedes-Benz", "S-klasse", "S500", 7000000, 2015);
        c1.println();
        Car c2 = new Car("BMW", "7 Series", "750 Li", 7005000, 2016);
        c2.println();
        Car c3 = new Car("Audi", "A8", "Long", 7450000, 2016);
        c3.println();

        System.out.println("\n--------Задание 4--------\n");

        System.out.println("\n--Демонстрация перечислений enum.--");

        Day current = Day.MONDAY;
        System.out.println(current);    // MONDAY

        System.out.println("\n--Демонстрация перечислений в классах для хранения данных.--");

        Books b1 = new Books("War and Peace", "L. Tolstoy", Type.BELLETRE);
        System.out.printf("Book '%s' has a type %s", b1.name, b1.bookType);

        switch(b1.bookType){
            case BELLETRE:
                System.out.println("Belletre");
                break;
            case SCIENCE:
                System.out.println("Science");
                break;
            case SCIENCE_FICTION:
                System.out.println("Science fiction");
                break;
            case PHANTASY:
                System.out.println("Phantasy");
                break;
        }

        System.out.println("\n--Демонстрация метода values у перечислений. Он возвращает массив всех констант перечисления.--");

        Type[] types = Type.values();
        for (Type s : types) { System.out.println(s); }

        System.out.println("\n--Демонстрация конструктора и полей в перечислениях.--");

        System.out.println(Color.RED.getCode());
        System.out.println(Color.GREEN.getCode());

        System.out.println("\n--Определение методов для определённых констант--");

        Operation op = Operation.SUM;
        System.out.println(op.action(10, 4));   // 14
        op = Operation.MULTIPLY;
        System.out.println(op.action(6, 4));    // 24

    }

    enum Day{

        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    static class Books{

        String name;
        Type bookType;
        String author;

        Books(String name, String author, Type type){

            bookType = type;
            this.name = name;
            this.author = author;
        }
    }

    enum Type
    {
        SCIENCE,
        BELLETRE,
        PHANTASY,
        SCIENCE_FICTION
    }

    enum Color{
        RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
        private String code;
        Color(String code){
            this.code = code;
        }
        public String getCode(){ return code;}
    }

    enum Operation{
        SUM{
            public int action(int x, int y){ return x + y;}
        },
        SUBTRACT{
            public int action(int x, int y){ return x - y;}
        },
        MULTIPLY{
            public int action(int x, int y){ return x * y;}
        };
        public abstract int action(int x, int y);
    }

    static void read(Printables p){

        p.print();
    }

    static Printables createPrintables(String name, boolean option){

        if(option)
            return new Book(name, "Undefined");
        else
            return new Journal(name);
    }
}

class ButtonClickHandler implements EventHandler{

    public void execute(){

        System.out.println("Кнопка нажата!");
    }
}

interface EventHandler{

    void execute();
}

class Button{

    EventHandler handler;
    Button(EventHandler action){

        this.handler=action;
    }
    public void click(){

        handler.execute();
    }
}

class WaterPipe implements Stateable{

    public void printState(int n){
        if(n==OPEN)
            System.out.println("Water is opened");
        else if(n==CLOSED)
            System.out.println("Water is closed");
        else
            System.out.println("State is invalid");
    }
}
interface Stateable{

    int OPEN = 1;
    int CLOSED = 0;

    void printState(int n);
}

class Calculation implements Calculatable{

}
interface Calculatable{

    default int sum(int a, int b){
        return sumAll(a, b);
    }
    default int sum(int a, int b, int c){
        return sumAll(a, b, c);
    }

    private int sumAll(int... values){
        int result = 0;
        for(int n : values){
            result += n;
        }
        return result;
    }
}

interface Printables{

    void print();
}
class Book implements Printables{

    String name;
    String author;

    Book(String name, String author){

        this.name = name;
        this.author = author;
    }

    public void print() {

        System.out.printf("%s (%s) \n", name, author);
    }
}
class Journal implements Printables {

    private String name;

    String getName(){
        return name;
    }

    Journal(String name){

        this.name = name;
    }
    public void print() {
        System.out.println(name);
    }
}