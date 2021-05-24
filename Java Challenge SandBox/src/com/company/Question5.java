package com.company;

public class Question5 {
    //Word Connect!
    //Write a function that connects a previous word to the next removing overlapping characters in the progress
    //Include the minimum number of shared letters
    //Ex. join(["move", "over", "very"]) ➞ ["movery", "3"] / join(["cat", "fish"]) ➞ ["catfish", "0"]

    public static String[] join(String[] letters) {
        String str = letters[0];
        int min = 20;
        for (int i = 1; i < letters.length; i++){
            str += " " + letters[i];
            min = Math.min(min, str.length()-str.replaceAll("(\\w+)\\s(?=\\1)", "").replaceAll("\\s", "").length() - 1);
            str = str.replaceAll("(\\w+)\\s(?=\\1)", "").replaceAll("\\s", "");
        }
        return new String[]{str, String.valueOf(min)};
    }
    }


