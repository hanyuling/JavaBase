package com.hanyuling.algorithm.other;

public class HammingWeight {

    public static void main(String[] args) {
        //00000000000000000000000010000000
        System.out.println(hammingWeight(256));
//        System.out.println(hammingWeight2(256));
    }

    public static int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if ((n & 1 << i) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public static int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= (n - 1);
            ret++;
        }
        return ret;
    }
}
