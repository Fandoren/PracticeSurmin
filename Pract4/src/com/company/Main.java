package com.company;

//Практическая работа 4-5

import java.util.Arrays;

public class Main {

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void InsertionSort(int[] a) {
        for (int left = 0; left < a.length; left++) {
            int value = a[left];
            int i = left - 1;
            for (; i >= 0; i--) {

                if (value < a[i]) {
                    a[i + 1] = a[i];
                } else {
                    break;
                }
            }
            a[i + 1] = value;
        }
    }

    public static void main(String[] args) {
//------------------------------------------------Задание 1-------------------------------------------------------------
        System.out.println("------Задание 1------\n");

        Queue q = new Queue(10);
        System.out.println("--Создана очередь длиной " + q.GetLength() + "--");
        System.out.println("\n--Внесение значений в очередь--");

        q.Put(1);
        q.Put(2);

        System.out.println("\n--Извлечение значения, при заполненности очереди менее 25%--");
        System.out.println("Вытащали из очереди элемент: " + q.Get());

        System.out.println("\n--Внесение значений в очередь сверх ограничения--");
        q.Put(3);
        q.Put(4);
        q.Put(10);
        q.Put(6);
        q.Put(4);
        q.Put(5);
        q.Put(9);
        q.Put(8);

        System.out.println("\n--Извлечение значений--");
        System.out.println("Вытащали из очереди элемент: " + q.Get());
        System.out.println("Вытащали из очереди элемент: " + q.Get());

        System.out.println("\n--Сортировка текущей очереди(Методом вставки)--");
        System.out.println("Вывод текущей очереди");
        int[] a = q.GetAll();
        System.out.println(Arrays.toString(a));

        q.InsertionSort();
        System.out.println("Отсортированная очередь");
        a = q.GetAll();

        System.out.println(Arrays.toString(a));
//------------------------------------------------Задание 2-------------------------------------------------------------
        System.out.println("\n------Задание 2------\n");
        System.out.println("--Вариант 2--\n");

        double sum = 0.0;
        int[] arr = new int[30];

        for(int i = 0; i < arr.length; i++)
            arr[i] = getRandomNumber(0,20);
        System.out.println(Arrays.toString(arr));

        System.out.println("--Сортировка вставкой--");
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("--Среднее значение--");
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        System.out.printf("\nСреднее значение: %.2f",sum/30);

    }
}



class Queue{
    private int length;
    private int[] queue;
    private int counter = 0, getter = 0;

    Queue(int length) {
        if(length > 0) {
            this.length = length;
            queue = new int[length];
        }
        else {
            System.out.println("Недопустимый размер очереди");
        }
    }

    void Put(int val) {
        if(counter <= length - 1){
            queue[counter++] = val;
            System.out.println("В очередь внесён элемент: " + val);
        }
        else{
            System.out.println("Недостаточный размер очереди, увеличиваю очередь на " + length + " элементов.");
            int[] temp = queue.clone();
            length *= 2;
            queue = new int[length];
            for(int i = 0; i < temp.length; i++)
                queue[i] = temp[i];
            queue[counter++] = val;
            System.out.println("В очередь внесён элемент: " + val);
        }
    }

    int GetLength()
    {
        return length;
    }

    int Get() {
        if(getter <= length - 1)
        {
            if(counter <= length * 0.25)
            {
                System.out.println("Используется меньше 25% очереди, уменьшаю длину очереди");
                int[] temp = queue.clone();
                length *= 0.25;
                queue = new int[++length];
                for(int i = 0; i < queue.length; i++)
                    queue[i] = temp[i];
                System.out.println("Новая длина очереди: " + length + " элемента");
                return queue[getter++];
            }
            return queue[getter++];
        }
        else return -1;
    }

    int[] GetAll(){

        int[] curQueue = new int[length - getter];
        for(int i = getter, j = 0; i <= length - 1; i++, j++)
            curQueue[j] = queue[i];
        return curQueue;
    }

    void InsertionSort(){
        int[] curQueue = new int[length - getter];
        for(int i = getter, j = 0; i <= length - 1; i++, j++)
            curQueue[j] = queue[i];

        Main.InsertionSort(curQueue);

        for(int i = getter, j = 0; i <= length - 1; i++, j++)
            queue[i] = curQueue[j];
    }

}
