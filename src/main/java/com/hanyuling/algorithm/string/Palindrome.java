package com.hanyuling.algorithm.string;

import java.util.Locale;

public class Palindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "ab_a";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length()-1;
        while (head <= tail){
            while (head<tail && !Character.isLetterOrDigit(s.charAt(head))){
                head++;
            }
            while (head<tail && !Character.isLetterOrDigit(s.charAt(tail))){
                tail--;
            }
            if (head < tail && Character.toUpperCase(s.charAt(head)) != Character.toUpperCase(s.charAt(tail))){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
