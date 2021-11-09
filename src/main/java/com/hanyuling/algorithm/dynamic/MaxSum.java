package com.hanyuling.algorithm.dynamic;

public class MaxSum {
    public static void main(String[] args) {
        int[] nums = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int max = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(0, cur) + nums[i];
            max = Math.max(max, cur);
        }
        return max;
    }
}
