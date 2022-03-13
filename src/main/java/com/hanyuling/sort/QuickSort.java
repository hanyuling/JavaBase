package com.hanyuling.sort;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 3, 7, 8, 1, 5, 9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        quikSort(nums, low, high);

    }

    private static void quikSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int p = nums[i];
        while (i < j) {
            while (i < j && p < nums[j]) {
                j--;
            }
            while (i < j && p > nums[i]) {
                i++;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[i] = p;
        quikSort(nums, low, i - 1);
        quikSort(nums, i + 1, high);
    }


}
