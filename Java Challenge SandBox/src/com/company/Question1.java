package com.company;

import java.util.Arrays;

public class Question1 {
    //What is the  Largest Number in an Array?
    // Build a Method that takes in an Array of numbers(Integers). The code should return the largest number in the Array.

    //Solution
    public static int FindLargestNumber(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}
