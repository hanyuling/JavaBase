package com.hanyuling.algorithm.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        shellSort(SortUtils.nums);
        System.out.println(Arrays.toString(SortUtils.nums));
    }

    /**
     * 直接插入排序的升级
     * 第一个打破 O(n^2) 的排序算法
     * 时间复杂度 O(n^(3/2))
     * @param nums
     */
    public static void shellSort(int[] nums) {
        int increment = nums.length;
        int tmp, j;
        do {
            increment = increment / 3 + 1;
            for (int i = increment ; i < nums.length; i++) {
                if (nums[i] < nums[i - increment]) {
                    tmp = nums[i];
                    for (j = i - increment; j >= 0 && nums[j] > tmp; j -= increment) {
                        nums[j + increment] = nums[j];
                    }
                    nums[j + increment] = tmp;
                }

            }
        }while (increment>1);

    }
}
