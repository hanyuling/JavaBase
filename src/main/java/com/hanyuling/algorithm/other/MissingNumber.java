package com.hanyuling.algorithm.other;

public class MissingNumber {

    public static int missingNumber(int[] nums){
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i] ^ i;
        }
        xor ^= nums.length;
        return xor;
    }
}
