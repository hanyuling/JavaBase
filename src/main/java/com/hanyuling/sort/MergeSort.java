package com.hanyuling.sort;

import com.hanyuling.algorithm.sort.SortUtils;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] nums = {2, 5, 3, 7, 8, 1, 6, 4, 9};
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        msort(nums, low, high);
    }

    private void partionAndSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
        partionAndSort(nums, low, mid);
        partionAndSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, index = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= high) {
            tmp[index++] = nums[j++];
        }
        for (int k = 0; k < tmp.length ; k++) {
            nums[k + low] = tmp[k];
        }
    }

    private static void msort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        msort(nums, low, mid);
        msort(nums, mid + 1, high);
        merge2(nums, low, mid, high);
    }

    private static void merge2(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high-low+1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= high) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, low, tmp.length);
    }
}
