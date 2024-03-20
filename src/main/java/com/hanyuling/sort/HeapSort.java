package com.hanyuling.sort;

import com.hanyuling.algorithm.sort.SortUtils;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        System.out.println((10 << 1) + 1);
        int[] nums = {12, 3, 5, 6, 2, 76, 34, 56, 24, 15, 67, 35};
        heapSort2(nums);
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

    public static void heapSort2(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            adjustHeap2(nums,i,nums.length-1);
        }
        for (int i = nums.length-1; i >0 ; i--) {
            int tmp=nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            adjustHeap(nums,0,i-1);
        }
    }

    private static void adjustHeap2(int[] nums, int m, int n) {
        int tmp = nums[m];
        for (int i = 2 * m + 1; i <= n; i = 2 * i + 1) {
            if (i + 1 <= n && nums[i + 1] > nums[i]) {
                i++;
            }
            if (tmp > nums[i]) {
                break;
            }
            nums[m] = nums[i];
            m = i;
        }
        nums[m] = tmp;
    }

}
