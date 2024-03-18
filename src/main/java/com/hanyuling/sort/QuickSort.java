package com.hanyuling.sort;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 3, 7, 8,8, 1, 5, 9};
//        int[] nums = {3,2,3,1,2,4,5,5,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        quickSort2(nums, low, high);

    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high;
        int p = nums[i];
        while (i < j) {
            while (i < j && p <= nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && p > nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = p;
        quickSort(nums, i + 1, high);
        quickSort(nums, low, i - 1);
    }


    private static void quickSort2(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high;
        int tmp = nums[i];
        while (i < j) {
            while (i < j && tmp <= nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && tmp >= nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = tmp;
        quickSort2(nums, low, i);
        quickSort2(nums, i + 1, high);
    }
}
