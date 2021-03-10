package com.company;

import java.security.*;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class Main {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    static Scanner sc = new Scanner(System.in);
    public KeyGenerator keygen;
    public SecretKey secKey;
    Cipher c;

    static SecureRandom rnd = new SecureRandom();
    static IvParameterSpec iv = new IvParameterSpec(rnd.generateSeed(8));

    public static void main(String[] args) throws Exception
    {
        Main theApp = new Main();
        theApp.start();
    }

    public void start() throws Exception
    {
        keygen = KeyGenerator.getInstance("DES");
        secKey = keygen.generateKey();

        System.out.println(secKey);

        boolean success = false;
        boolean success2 = false;
        boolean exit = false;
        int type = 0;

        do
        {
            do
            {
                System.out.println("Хотите продолжить? y/q");
                String input = sc.nextLine();

                if(input.equalsIgnoreCase("y")){

                    type = 1;
                            c = Cipher.getInstance("DES/ECB/NoPadding");
                            success = true;
                            success2 = true;
                }
                else if(input.equalsIgnoreCase("q")){
                    System.out.println("Thanks for using me!");
                    System.exit(0);
                    success = true;
                    exit = true;
                }
                else{
                    System.out.println("Error - please enter a valid input");
                    success = false;
                }
            }while(!success);


            System.out.println("Input what you wish to encrypt");
            String input = "СУРМИНАГ";

            byte[] text = input.getBytes();

            System.out.println(type);

            System.out.println("--------------------------------------------");

            System.out.println("Текст : " + new String(text));

            byte[] textEncrypted = encrypt(text, c, type);

            System.out.println("Зашифрованный текст: " + bytesToHex(textEncrypted));

            byte[] textDecrypted = decrypt(textEncrypted, c, type);

            System.out.println("Расшифрованный текст: " + new String(textDecrypted));

            System.out.println("Ключ: " + Base64.getEncoder().encodeToString(secKey.getEncoded()));

            System.out.println("--------------------------------------------");

        }while(!exit);
    }

    public byte[] encrypt(byte[] b, Cipher c, int type) throws Exception
    {
        if(type == 1)
        {
            c.init(Cipher.ENCRYPT_MODE, secKey);
        }
        else if(type == 2)
        {
            c.init(Cipher.ENCRYPT_MODE, secKey, iv);
        }
        byte[] encryptedText = null;
        try {
            encryptedText = c.doFinal(b);
        } catch (IllegalBlockSizeException e) {
            System.out.println("ERROR - If you have selected to not automatically pad your plaintext it must be a mutiple of eight bytes to be accepted. Exiting program");
            System.exit(0);
        }

        return encryptedText;
    }

    public byte[] decrypt(byte[] b, Cipher c, int type) throws Exception
    {
        if(type == 1)
        {
            c.init(Cipher.DECRYPT_MODE, secKey);
        }
        else if(type == 2)
        {
            c.init(Cipher.DECRYPT_MODE, secKey, iv);
        }

        byte[] decryptedText = c.doFinal(b);

        return decryptedText;
    }
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
