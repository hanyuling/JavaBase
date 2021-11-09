package com.hanyuling.algorithm.sort;

public class SortUtils {
    public static int[] nums = {9, 1, 5, 8, 3, 7, 4, 6, 2};
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
