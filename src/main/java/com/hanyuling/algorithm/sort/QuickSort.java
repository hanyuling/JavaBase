package com.hanyuling.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort(SortUtils.nums);
        System.out.println(Arrays.toString(SortUtils.nums));
    }

    /**
     * 时间复杂度：O(nlogn)
     * 时间复杂度最差：O(n^2)
     * 空间复杂度：O(logn)
     * 空间复杂度最差：O(n)
     * 不稳定
     * @param nums
     */
    public static void QuickSort(int[] nums) {
        QSort(nums, 0, nums.length - 1);
    }

    private static void QSort(int[] nums, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(nums, low, high);
            QSort(nums, low, pivot);
            QSort(nums, pivot + 1, high);
        }
    }

    private static void QSort1(int[] nums, int low, int high) {
        int pivot;
        while (low < high){
            pivot = partition(nums, low, high);
            QSort1(nums,low,pivot-1);
            low = pivot+1;
        }
    }


    private static int partition(int[] nums, int low, int high) {

        int tmp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= tmp) {
                high--;
            }
//            SortUtils.swap(nums,low,high);
            nums[low] = nums[high];
            while (low < high && nums[low] <= tmp) {
                low++;
            }
//            SortUtils.swap(nums,low,high);
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }


}
