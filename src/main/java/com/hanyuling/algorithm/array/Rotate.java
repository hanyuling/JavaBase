package com.hanyuling.algorithm.array;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int tmp = 0;
        while (start < end) {
            tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
