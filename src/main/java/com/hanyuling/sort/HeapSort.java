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

        for (int i = (nums.length - 1) >>> 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0]=tmp;
            adjustHeap(nums, 0, i);
        }

    }

    private static void adjustHeap(int[] nums, int parent, int length) {
        int tmp = nums[parent];
        int lchild = (parent << 1) + 1;

        while (lchild < length) {
            int rchild = lchild + 1;
            if (rchild < length && nums[rchild] > nums[lchild]) {
                lchild++;
            }

            if (tmp > nums[lchild]) {
                break;
            }

            nums[parent] = nums[lchild];
            parent = lchild;
            lchild = (lchild << 1) + 1;
        }

        nums[parent] = tmp;
    }


}
