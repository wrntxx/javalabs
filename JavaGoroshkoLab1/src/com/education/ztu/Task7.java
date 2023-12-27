package com.education.ztu;

import java.util.ArrayList;

public class Task7 {
    public static void main(String[] args) {
        ArrayList<Character> alphabet = new ArrayList<Character>();

        for (int i = 'A'; i <= 'Z'; i++) {
            alphabet.add((char)i);
        }

        for (Character character : alphabet) {
            System.out.println(character + " ==> "+ (int)character);
        }
    }
}
