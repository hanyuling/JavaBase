package com.hanyuling.algorithm.sort;

import java.util.Arrays;

public class Bubblesort {

    public static void main(String[] args) {
        int[] nums = {1,2,3,7,5,6,4,9,8};
//        bubblesort(nums);
        bubblesort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubblesort(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    SortUtils.swap(nums, i, j);
                    count ++;
                }
            }
        }
        System.out.println(count);
    }

    //正宗冒泡排序

    /**
     * 时间复杂度：O(n^2)
     * 最好情况：O(n)
     * @param nums
     */
    public static void bubblesort2(int[] nums) {
//        boolean flag = true; // 对冒泡排序的优化
        int count = 0;
        for (int i = 0; i < nums.length /*&& flag*/; i++) {
//            flag = false; // 对冒泡排序的优化
            for (int j = nums.length - 2; j >= i; j--) {
                if (nums[j] > nums[j + 1]) {
                    SortUtils.swap(nums, j, j + 1);
                    count ++;
//                    flag = true; // 对冒泡排序的优化
                }
            }
        }
        System.out.println(count);
    }
}
