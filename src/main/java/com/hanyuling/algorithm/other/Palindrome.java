package com.hanyuling.algorithm.other;

public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return revertedNumber == x || revertedNumber / 10 == x;

    }
}
