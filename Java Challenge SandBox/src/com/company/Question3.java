package com.company;

import java.util.Arrays;

public class Question3 {
    //Are you an Isogram?? Isogram - A word with no duplicated letters ex - "Pie"
    //Create a function that takes a string and returns true or false if its an Isogram or not

    //Solution
    public static boolean IsIso(String str) {
        str = str.toLowerCase();
        char[] cha = str.toCharArray();
        Arrays.sort(cha);
        for(int i = 0; i < cha.length - 1; i++) {
            if(cha[i] == cha[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
