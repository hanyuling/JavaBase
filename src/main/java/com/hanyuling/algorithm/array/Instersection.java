package com.hanyuling.algorithm.array;

import java.util.Arrays;

public class Instersection {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        int index1 = 0;
        int index2 = 0;
        int tmp = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                result[tmp] = nums1[index1];
                tmp++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result, 0, tmp);
    }
}
