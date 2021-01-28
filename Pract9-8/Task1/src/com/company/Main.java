package com.company;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class Main {

    static class JThread1 extends Thread {

        JThread1(String name){
            super(name);
        }
        public void run(){

            System.out.printf("%s started... \n", Thread.currentThread().getName());
            int counter=1; // счетчик циклов
            while(!isInterrupted()){

                System.out.println("Loop " + counter++);
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        }
    }

    static class JThread extends Thread {

        JThread(String name){
            super(name);
        }

        public void run(){

            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        }

    }

    static class MyThread implements Runnable {
        private boolean isActive;

        void disable(){
            isActive=false;
        }

        MyThread(){
            isActive = true;
        }

        public void run(){

            System.out.printf("%s started... \n", Thread.currentThread().getName());
            int counter=1; // счетчик циклов
            while(isActive){
                System.out.println("Loop " + counter++);
                try{
                    Thread.sleep(400);
                }
                catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        }
    }

    static class CommonResource{

        int x;
        synchronized void increment(){
            x=1;
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
                x++;
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){}
            }
        }
    }

    static class CountThread implements Runnable{

        CommonResource res;
        CountThread(CommonResource res){
            this.res=res;
        }

        public void run(){
            res.increment();
        }
    }

    static class Store{
        private int product=0;
        public synchronized void get() {
            while (product<1) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                }
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify();
        }
        public synchronized void put() {
            while (product>=3) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                }
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify();
        }
    }
    // класс Производитель
    static class Producer implements Runnable{

        Store store;
        Producer(Store store){
            this.store=store;
        }
        public void run(){
            for (int i = 1; i < 6; i++) {
                store.put();
            }
        }
    }
    // Класс Потребитель
    static class Consumer implements Runnable{

        Store store;
        Consumer(Store store){
            this.store=store;
        }
        public void run(){
            for (int i = 1; i < 6; i++) {
                store.get();
            }
        }
    }

    static class CountThread1 implements Runnable{

        CommonResource res;
        Semaphore sem;
        String name;
        CountThread1(CommonResource res, Semaphore sem, String name){
            this.res=res;
            this.sem=sem;
            this.name=name;
        }

        public void run(){

            try{
                System.out.println(name + " ожидает разрешение");
                sem.acquire();
                res.x=1;
                for (int i = 1; i < 5; i++){
                    System.out.println(this.name + ": " + res.x);
                    res.x++;
                    Thread.sleep(100);
                }
            }
            catch(InterruptedException e){System.out.println(e.getMessage());}
            System.out.println(name + " освобождает разрешение");
            sem.release();
        }
    }

    static class PutThread implements Runnable{

        Exchanger<String> exchanger;
        String message;

        PutThread(Exchanger<String> ex){

            this.exchanger=ex;
            message = "Hello Java!";
        }
        public void run(){

            try{
                message=exchanger.exchange(message);
                System.out.println("PutThread has received: " + message);
            }
            catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    static class GetThread implements Runnable{

        Exchanger<String> exchanger;
        String message;

        GetThread(Exchanger<String> ex){

            this.exchanger=ex;
            message = "Hello World!";
        }
        public void run(){

            try{
                message=exchanger.exchange(message);
                System.out.println("GetThread has received: " + message);
            }
            catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    static class PhaseThread implements Runnable{

        Phaser phaser;
        String name;

        PhaseThread(Phaser p, String n){

            this.phaser=p;
            this.name=n;
            phaser.register();
        }
        public void run(){

            System.out.println(name + " выполняет фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
            try{
                Thread.sleep(200);
            }
            catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }

            System.out.println(name + " выполняет фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута
            try{
                Thread.sleep(200);
            }
            catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(name + " выполняет фазу " + phaser.getPhase());
            phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
        }
    }

    public static void main(String[] args) {
        System.out.println("\n-----Задание 1-----\n");
        System.out.println("--Демонстрация работы класса Thread--");
        System.out.println("Main thread started...");
        JThread t= new JThread("JThread ");
        t.start();
        try{
            System.out.println("метод join заставляет вызвавший поток ожидать завершения вызываемого потока");
            t.join();
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");

        System.out.println("\n--Демонстрация работы интерфейса Runnable--");
        System.out.println("Main thread started...");
        MyThread myThread = new MyThread();
        new Thread(myThread,"MyThread").start();

        try{
            Thread.sleep(1100);

            myThread.disable();

            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");


        System.out.println("\n--Демонстрация работы метода interrupt--");
        System.out.println("Main thread started...");
        JThread1 a = new JThread1("JThread");
        a.start();
        try{
            Thread.sleep(150);
            a.interrupt();

            Thread.sleep(150);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");

        System.out.println("\n--Демонстрация работы метода interrupt--");

        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 6; i++){

            Thread b = new Thread(new CountThread(commonResource));
            b.setName("Thread "+ i);
            b.start();
        }

        System.out.println("\n--Демонстрация работы методов wait и notify--");

        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();

        System.out.println("\n--Демонстрация работы семафор--");

        Semaphore sem = new Semaphore(1); // 1 разрешение
        CommonResource res = new CommonResource();
        new Thread(new CountThread1(res, sem, "CountThread 1")).start();
        new Thread(new CountThread1(res, sem, "CountThread 2")).start();
        new Thread(new CountThread1(res, sem, "CountThread 3")).start();

        System.out.println("\n--Демонстрация работы Exchanger--");

        Exchanger<String> ex = new Exchanger<String>();
        new Thread(new PutThread(ex)).start();
        new Thread(new GetThread(ex)).start();

        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        System.out.println("\n--Демонстрация работы Phaser--");

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();

    }
}
