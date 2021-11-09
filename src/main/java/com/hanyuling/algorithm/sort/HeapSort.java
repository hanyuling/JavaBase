package com.hanyuling.algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        heapSort(SortUtils.nums);
        System.out.println(Arrays.toString(SortUtils.nums));
        int[] aa = {2,4,5,2,55,45,34,64,75,78,34,65,2,32,43,654,75,34,55,654,456,45,64,564,456,734,894,37,23};
        heapSort(aa);
        System.out.println(Arrays.toString(aa));
    }

    /**
     * 时间复杂度总体：O(n)+O(nlogn)
     * 时间复杂度：O(nlogn)
     * 最好最坏：O(nlogn)
     * 不稳定
     * 利用 完全二叉树的深度是[log2n] + 1
     * @param nums
     */
    public static void heapSort(int[] nums) {
        int i;
        for (i = nums.length - 1; i >= 0; i--) {
            heapAdjust(nums, i, nums.length - 1);
        }
        for (i = nums.length - 1; i >= 0; i--) {
            SortUtils.swap(nums, 0, i);
            heapAdjust(nums, 0, i-1 );
        }
    }

    private static void heapAdjust(int[] nums, int n, int m) {
        int tmp = nums[n];
        for (int i = 2 * n + 1; i <= m; i = 2 * i + 1) {
            if (i + 1 < m && nums[i] < nums[i + 1]) {
                i++;
            }
            if (tmp > nums[i]) {
                break;
            }

            nums[n] = nums[i];
            n = i;
        }
        nums[n] = tmp;

    }
}
