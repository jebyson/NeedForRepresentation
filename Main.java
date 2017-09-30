package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        String[] representations = {"binary","octal","decimal","hexadecimal","ASCII"};

        System.out.println("Enter a word: ");
        Scanner input = new Scanner(System.in);
        char[] word = input.nextLine().toCharArray();

        int correlation = (int)((Math.random()*5) + 1);
        int position = (int)(Math.random()*word.length + 1);
        int i = 0;
        int currRep = correlation - 1;
        int currWord = position - 1;
        String[] encryptString = new String[word.length];
        System.out.println("Random correlation is " + correlation + " and Random position is " + position);
        while (i < word.length){
            i++;
            if(currWord == word.length) {
                currWord = 0;
            }
            if(currRep == 5) {
                currRep = 0;
            }
            if(representations[currRep].equals("binary")) {
                encryptString[currWord] = Integer.toBinaryString(word[currWord]);
            }
            if(representations[currRep].equals("octal")) {
                encryptString[currWord] = Integer.toOctalString(word[currWord]);
            }
            if(representations[currRep].equals("decimal")) {
                encryptString[currWord] = Integer.toString((int)(word[currWord]));
            }
            if(representations[currRep].equals("hexadecimal")) {
                encryptString[currWord] = Integer.toHexString(word[currWord]);
            }
            if(representations[currRep].equals("ASCII")) {
                encryptString[currWord] = Character.toString(word[currWord]);
            }
            currRep++;
            currWord++;
        }
        for (String s: encryptString) {
            System.out.print(s);
        }
    }
}