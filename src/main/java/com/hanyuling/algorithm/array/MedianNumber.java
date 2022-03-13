package com.hanyuling.algorithm.array;

public class MedianNumber {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(getMedian(nums));
    }

    public static int getMedian(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                int tmp = i + mid >= len ? i + mid - len : i + mid;
                return nums[tmp];
            }
        }
        return nums[mid];
    }
}
