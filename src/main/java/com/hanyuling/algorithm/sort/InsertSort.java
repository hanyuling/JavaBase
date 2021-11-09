package com.hanyuling.algorithm.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        insertSort(SortUtils.nums);
        insertSort(SortUtils.nums);
        System.out.println(Arrays.toString(SortUtils.nums));
    }

    /**
     * 适用于记录少且基本有序
     * 空间复杂度：O(1)
     * 时间复杂度：O(n^2)
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                int tmp = nums[i + 1];
                int j;
                for ( j = i; j >= 0 && tmp < nums[j]; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[j+1] = tmp;
            }
        }
    }
}
