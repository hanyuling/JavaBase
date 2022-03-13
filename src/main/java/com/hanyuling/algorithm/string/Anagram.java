package com.hanyuling.algorithm.string;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram2(s,t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        int[] table = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            table[index] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            table[index] -- ;
            if (table[index] <0){
                return false;
            }
        }

        return true;
    }
    public static boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
