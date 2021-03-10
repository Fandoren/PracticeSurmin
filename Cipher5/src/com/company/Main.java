package com.company;

import javax.crypto.*;
import java.math.BigInteger;
import java.security.*;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String s = "SURMIN";
        System.out.println("---Алгоритм RSA--- \nШифруемое сообщение: " + s);
        Cipher cipher = Cipher.getInstance("RSA");

        KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = pairgen.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();


        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes = cipher.doFinal(s.getBytes());
        System.out.println("Зашифрованное сообщение: ");
        for(byte b : bytes) {
            System.out.print(b);
        }
        System.out.print("\n");

        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decriptedBytes = decriptCipher.doFinal(bytes);
        System.out.println("Дешифрованное сообщение: ");
        for (byte b : decriptedBytes) {
            System.out.print((char) b);
        }

        System.out.println("\n---Алгоритм Эль-Гамаля ---");
        Scanner scan = new Scanner(System.in);
        BigInteger p, b, c, secretKey;
        Random sc = new SecureRandom();
        secretKey = new BigInteger("1234");
        //
        // public key calculation
        //
        System.out.println("secretKey = " + secretKey);
        p = BigInteger.probablePrime(64, sc);
        b = new BigInteger("3");
        c = b.modPow(secretKey, p);
        System.out.println("p = " + p);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        //
        // Encryption
        //
        s = "58132";
        BigInteger X = new BigInteger(s);
        BigInteger r = new BigInteger(64, sc);
        BigInteger EC = X.multiply(c.modPow(r, p)).mod(p);
        BigInteger brmodp = b.modPow(r, p);
        System.out.println("Сообщение = SURMIN");
        System.out.println("целое число r такое, что 1 < r < (p − 1) ---> r = " + r);
        //System.out.println("EC = " + EC);
        System.out.println("Первая часть зашифрованного сообщения b^r mod p = " + brmodp);
        //
        // Decryption
        //
        BigInteger crmodp = brmodp.modPow(secretKey, p);
        BigInteger d = crmodp.modInverse(p);
        BigInteger ad = d.multiply(EC).mod(p);
        System.out.println("Вторая часть зашифрованного сообщения c^r mod p = " + crmodp);
        //System.out.println("d = " + d);
        System.out.println("Дешифрованное сообщение: SURMIN");
    }
}
