package com.hanyuling.algorithm.string;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
       char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        char tmp = '0';
        int high = s.length - 1;
        int low = 0;
        while (low < high) {
            tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            low++;
            high--;
        }
    }
}
