package com.hanyuling.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        System.out.println((10 << 1) + 1);
        int[] nums = {12, 3, 5, 6, 2, 76, 34, 56, 24, 15, 67, 35};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums) {

        for (int i = (nums.length - 1)/2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length-1);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0]=tmp;
            adjustHeap(nums, 0, i-1);
        }

    }

    private static void adjustHeap(int[] nums, int n, int m) {
        int p = nums[n];
        for (int i = 2 * n + 1; i <= m; i = 2 * i + 1) {
            if (i + 1 <= m && nums[i + 1] > nums[i]) {
                i++;
            }
            if (p > nums[i]) {
                break;
            }
            nums[n] = nums[i];
            n = i;
        }
        nums[n] = p;
    }

}
