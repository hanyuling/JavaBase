package com.hanyuling.algorithm.other;

public class RomanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        //前一个数字表示的值
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            //如果前一个数字比现在数字小，说明
            //前一个字符和现在字符组合成一个有效数字，
            if (preNum < num) {
                sum -= preNum;
            } else {
                //如果前一个数字不比现在数字小，说明
                //每个字符都是一个有效的数字
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
