package com.hanyuling.algorithm.array;

import java.util.Arrays;

public class TopN {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 8, 9, 6, 7, 3, 2};
        int[] getmax = getmax(nums, 3);
        System.out.println(Arrays.toString(getmax));

    }

    public static int[] getmax(int[] nums, int k) {
        int[] result = new int[k];
        Arrays.fill(result, Integer.MIN_VALUE);
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if (result[j] < result[minIndex]) {
                    minIndex = j;
                }
            }
            if (nums[i] > result[minIndex]) {
                result[minIndex] = nums[i];
            }
        }
        return result;
    }
}
