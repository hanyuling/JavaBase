package com.hanyuling.algorithm.array;

import java.util.Objects;

public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-4, -3, -2};
        System.out.println(maxProduct(nums));
        Boolean b = Boolean.valueOf("true");
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int dp0 = 1;//最大
        int dp1 = 1;//最小
        for (int num : nums) {
            int tmp = dp0;
            dp0 = Math.max(Math.max(dp0 * num, num), dp1 * num);
            dp1 = Math.min(Math.min(dp1 * num, num), tmp * num);
            max = Math.max(dp0, max);
            min = Math.min(dp1, min);
        }

        return Math.max(max, min);
    }

    public static int maxProduct2(int[] nums) {
        int ans = nums[0];
        int dpa = nums[0];
        int dpi = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = dpa;
            int mn = dpi;
            dpa = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            dpi = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(ans, dpa);
        }
        return ans;
    }
}
