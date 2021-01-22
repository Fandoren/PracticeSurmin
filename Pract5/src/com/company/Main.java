package com.company;

import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Задание 1
        System.out.println("--Задание 1--\n");
        Person sasha = new Person("Sasha", 23, "Moscow", "+79217016510", "qwerty");
        System.out.println("--Методы класса Person--");
        sasha.display();
        sasha.displayAge();
        sasha.displayName();
        System.out.println("--Изменение имени. Метод setName--");
        sasha.setName("Alexander");
        sasha.displayName();
        sasha.displayPerson();
        sasha.displayPhone();
        System.out.println("--Статический метод класса Person, displayCounter--");
        Person.displayCounter();
        System.out.println("--Метод DisplayAccount вложенного класса Account--");
        sasha.account.displayAccount();

        System.out.println("--Статические методы Operation--");
        System.out.println("Multiply: " + Operation.multiply(5, 5));
        System.out.println("Substract: " + Operation.subtract(7, 5));
        System.out.println("Sum: " + Operation.sum(5, 5));

        System.out.println("--Объект класса Employee, наследующийся от Person--");
        Employee worker = new Employee("Igor", "SPBGUT");
        worker.display();

        System.out.println("--Объект класса Rectangle, наследующийся от абстрактного класса Figure--");
        Figure rect = new Rectangle(5, 5, 10, 10);
        System.out.println("Perimeter: " + rect.getArea());
        System.out.println("Area: " + rect.getPerimeter());

        System.out.println("\n--Задание 2--\n");

        double r;
        Circle k1 = new Circle(3.1, 4.1, 5.1, "\u201c");
        System.out.println("Длина окружности = " + k1.getLength() + "см\n");

        Scanner source = new Scanner(System.in);
        System.out.println("Введите радиус ");
        r = (double)source.nextDouble();
        k1.setR(r);
        System.out.println("\nДлина окружности = " + k1.getLength() + "см");
    }
}

class Person{

    private String name;
    private int age;
    private int id;
    static int counter=1;
    public String address;
    private String phone;
    Account account;

    static{
        counter = 105;
        System.out.println("Static initializer");
    }
    //Конструкторы
    public Person(String name, int age, String address, String phone, String password){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        account = new Account(password);
        id = counter++;
    }
    Person(String name){
        this.name = name;
    }
    Person(String name, String password){
        this.name = name;
        account = new Account(password);
    }
    //Методы
    public void setName(String name){
        this.name = name;
    }
    public String getName(){

        return this.name;
    }
    public void displayName(){
        System.out.printf("Name: %s \n", name);
    }
    void displayAge(){
        System.out.printf("Age: %d \n", age);
    }
    private void displayAddress(){
        System.out.printf("Address: %s \n", address);
    }
    protected void displayPhone(){
        System.out.printf("Phone: %s \n", phone);
    }
    public static void displayCounter(){

        System.out.printf("Counter: %d \n", counter);
    }
    public void displayPerson(){
        System.out.printf("Person \t Name: %s \t Password: %s \n", name, account.password);
    }
    public void display(){

        System.out.println("Name: " + name);
    }

    public class Account{
        private String password;

        Account(String pass){
            this.password = pass;
        }
        void displayAccount(){
            System.out.printf("Account Login: %s \t Password: %s \n", Person.this.name, password);
        }
    }
}

class Operation{

    static int sum(int x, int y){
        return x + y;
    }
    static int subtract(int x, int y){
        return x - y;
    }
    static int multiply(int x, int y){
        return x * y;
    }
}

class Employee extends Person{

    private String company;

    public Employee(String name, String company) {

        super(name);
        this.company=company;
    }
    @Override
    public void display(){

        System.out.printf("Name: %s \n", getName());
        System.out.printf("Works in %s \n", company);
    }
}

abstract class Figure{

    float x; // x-координата точки
    float y; // y-координата точки

    Figure(float x, float y){

        this.x=x;
        this.y=y;
    }
    // абстрактный метод для получения периметра
    public abstract float getPerimeter();
    // абстрактный метод для получения площади
    public abstract float getArea();
}
// производный класс прямоугольника
class Rectangle extends Figure
{
    private float width;
    private float height;

    // конструктор с обращением к конструктору класса Figure
    Rectangle(float x, float y, float width, float height){

        super(x,y);
        this.width = width;
        this.height = height;
    }

    public float getPerimeter(){

        return width * 2 + height * 2;
    }

    public float getArea(){

        return width * height;
    }
}

class Circle{
    private double x;
    private double y;
    private double r;
    private String colour;

    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }

    public double getR(){
        return r;
    }
    public void setR(double r){
        this.r = r;
    }

    public String getColour(){
        return colour;
    }
    public void setColour(String colour){
        this.colour = colour;
    }

    public Circle(double x, double y, double r, String colour){
        this.x = x;
        this.y = y;
        this.r = r;
        this.colour = colour;
    }

    @Override
    public String toString(){
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", colour='" + colour + "\\'}";
    }

    public double getLength(){
        double c;
        c = 2*Math.PI*r;
        return c;
    }
}