package com.hanyuling.algorithm.array;

import java.time.LocalDate;
import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 0, 6, 7, 0, 8, 0, 2, 5, 9};
//        moveZeroes(nums);
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum += 1;
                continue;
            }
            if (zeroNum != 0) {
                nums[i - zeroNum] = nums[i];
            }
        }
        for (int i = nums.length - 1; i > nums.length - zeroNum - 1; i--) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void moveZero3(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

}
