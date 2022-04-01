package com.hanyuling.algorithm.logical;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y){
        int xor = x ^ y;
        int res = 0;
        while (xor != 0){
            res += xor & 1;
            xor = xor >>> 1;
        }
        return res;
    }
}
