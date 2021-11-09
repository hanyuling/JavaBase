package com.hanyuling.algorithm.dynamic;

public class Thief {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        var dp0 = 0;
        var dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            var dpi0 = Math.max(dp0, dp1);
            var dpi1 = dp0 + nums[i];
            dp0 = dpi0;
            dp1 = dpi1;
        }
        return dp0 > dp1 ? dp0 : dp1;
    }
}
