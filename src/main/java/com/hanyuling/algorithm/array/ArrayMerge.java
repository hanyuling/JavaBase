package com.hanyuling.algorithm.array;

import java.util.Arrays;

public class ArrayMerge {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums1 = {0};
        int m = 0;
//        int[] nums2 = {2, 5, 6};
        int[] nums2 = {};
        int n = 0;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int l = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] < nums1[i]) {
                nums1[l--] = nums1[i--];
            } else {
                nums1[l--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[l--] = nums2[j--];
        }
    }
}
