package com.company;

import java.io.*;

public class Main {
    static long ShiftRegister = (long) (Math.random() * (511 - 256)) +256;
    static String fileText = "";
    public static void main(String[] args ) throws IOException {
        FileReader reader = new FileReader("resources\\FileToOpen.txt");
        int c;
        while((c=reader.read())!=-1)
            fileText +=(char)c;

        FileWriter writer = new FileWriter("resources\\key.txt", false);
        writer.write(Long.toString(ShiftRegister));
        writer.flush();

        System.out.println("\nШИФРОВАНИЕ");
        System.out.printf("Начальное значение: %d (%s)\n",ShiftRegister,Long.toBinaryString(ShiftRegister));
        System.out.println("Файл: "+fileText);
        char[] arr = fileText.toCharArray();
        int n = arr.length * 8;

        String keyBin =Long.toString(ShiftRegister & 0x01);
        for(int i = 0; i <n-1; i++) {
            ShiftRegister = ((((ShiftRegister >> 1) ^ (ShiftRegister >> 2)) & 0x01) << 1) | (ShiftRegister >> 1);
            keyBin+=(ShiftRegister & 0x01);
        }

        String openHex = "", openBin ="";
        System.out.println("Ключ (гамма): "+keyBin);
        for (int i = 0; i<arr.length; i++)
        {
            int b = (int)arr[i];
            openHex += String.format("%x ", b);
            if((Integer.toBinaryString(b).length() == 7))
                openBin += "0";
            else if ((Integer.toBinaryString(b).length() == 6))
                openBin += "00";
            openBin += Integer.toBinaryString(b);
        }
        System.out.println("Файл (hex): "+openHex);
        System.out.println("Файл (bin): "+openBin);


        String closeBin = "", closeHex = "";
        for (int i = 0, j = 0; i < keyBin.length(); i++, j++)
            closeBin += (int)keyBin.charAt(i)^(int) openBin.charAt(i);
        System.out.println("Зашифрованное сообщение (bin): "+closeBin);


        String[] A = closeBin.split("(?<=\\G.{8})");
        String closet = "";
        for (int i =0 ; i<A.length;i++ )
        {
            closeHex+=String.format("%x ",Integer.parseInt(A[i],2));
            closet += (char)Integer.parseInt(A[i],2);
        }

        System.out.println("Зашифрованное сообщение (hex): "+closeHex);
        System.out.println("Зашифрованный текст: "+ closet);

        writer = new FileWriter("resources\\FileToClose.txt", false);
        writer.write(closet);
        writer.flush();

        System.out.println("\nДЕШИФРОВАНИЕ");
        String openDBin = "";

        for (int i = 0, j = 0; i < keyBin.length(); i++, j++)
            openDBin += (int)keyBin.charAt(i)^(int) closeBin.charAt(i);
        System.out.println("Текст после дешифрации (bin): "+openDBin);

        String[] B = openDBin.split("(?<=\\G.{8})");
        String openDt = "", openDHex = "";
        for (int i =0 ; i<B.length;i++ )
        {
            openDHex+=String.format("%x ",Integer.parseInt(B[i],2));
            openDt += (char)Integer.parseInt(B[i],2);
        }
        System.out.println("Текст после дешифрации (hex): "+openDHex);
        System.out.println("Дешифрованный текст: "+ openDt);

    }



}