package com.hanyuling.algorithm.array;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);

        System.out.println(Arrays.toString(ints));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i];
        }
        int r = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            result[i] = r * result[i-1];
            r *= nums[i];
        }
        result[0] = r ;
        return result;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n-1; i >=0 ; i--) {
            res[i] = r * res[i];
            r *= nums[i];
        }
        return res;
    }
}
