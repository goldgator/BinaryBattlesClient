package com.company;

public class Question4 {
    //Numbers..But Reversed
    // Code a function that takes in an int and reverses it
    // EX - [231 --> 132]  [25 --> 52]  [137 --> 731]

    //Solution
    public static int ReversedNum(int num) {
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }
        System.out.println(reversed);
        return num;
    }


    }

