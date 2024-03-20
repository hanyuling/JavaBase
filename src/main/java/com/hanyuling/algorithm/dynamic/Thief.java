package com.hanyuling.algorithm.dynamic;

public class Thief {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = dp1;
            dp1 = Math.max(dp1, dp0 + nums[i]);
            dp0 = tmp;
        }
        return dp1 > dp0 ? dp1 : dp0;
    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = dp1;
            dp1 = Math.max(dp1, dp0 + nums[i]);
            dp0 = tmp;
        }
        return dp1 > dp0 ? dp1 : dp0;
    }

    public static int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp0 = nums[1];
        int dp1 = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = dp1;
            dp1 = Math.max(dp1, dp0 + nums[i]);
            dp0 = tmp;
        }
        return dp1 > dp0 ? dp1 : dp0;
    }
}
