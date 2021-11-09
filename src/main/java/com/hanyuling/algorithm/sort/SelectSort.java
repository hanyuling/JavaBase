package com.hanyuling.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        selectSort(SortUtils.nums);
        System.out.println(Arrays.toString(SortUtils.nums));
    }

    /**
     * 时间复杂度：O(n^2)
     * @param nums
     */
    public static void selectSort(int[] nums) {
        int  min;
        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (i != min)
            SortUtils.swap(nums,i,min);
        }

    }
}
