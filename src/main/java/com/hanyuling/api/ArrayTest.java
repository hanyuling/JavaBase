package com.hanyuling.api;

public class ArrayTest {

    public static void main(String[] args) {
//        int end = 262143;
        int end = 0b11111111111111111;
//        int start = 131073;
        int start = 0b10000000000000001;
        System.out.println("start=== " + start);
        System.out.println("end=== " + end);
        int count = 0;
        for (int i = start; i < end; i++) {
            String s = Integer.toBinaryString(i);
            char[] chars = s.toCharArray();
            int count0 = 0;
            int count1 = 0;
            boolean flag = true;
            if (chars[chars.length - 1] == '0') {
                continue;
            }
            for (int j = 0; j < chars.length; j++) {
                if (count1 == 3 || count0 == 2) {
                    flag = false;
                    break;
                }

                if (chars[j] == '1') {
                    count0 = 0;
                    count1++;
                } else if (chars[j] == '0') {
                    count1 = 0;
                    count0++;
                }
            }
            if (count1 == 3 || count0 == 2) {
                flag = false;
            }
            if (flag) {
                System.out.println("0" + s + "0");
                count++;
            }
        }

        System.out.println(count);

    }
}
