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
}
