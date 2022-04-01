package com.hanyuling.algorithm.array;

import java.util.Random;

public class TopK {
    static Random random = new Random();

    public static void main(String[] args) {
//        int[] nums = {3, 5, 2, 6, 4, 9, 7, 14, 8, 1, 10, 11};
//        int[] nums = {3, 5, 2, 6, 4, 9, 7};
        for (int i = 0; i < 10; i++) {
            int[] nums = {3,2,3,1,2,4,5,5,6};
            System.out.println(findKthLargest(nums, 4));
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        int i = quickSort(nums, low, high, index);
        return i;
    }

    private static int quickSort(int[] nums, int low, int high, int f) {
        if (low >= high) {
            return nums[low];
        }
        int index = random.nextInt(high - low + 1) + low;
        swap(nums, low, index);
        int i = low, j = high;
        int p = nums[i];
        while (i < j) {
            while (i < j && p <= nums[j]) {
                j--;
            }
            if (i<j){
                nums[i++] = nums[j];
            }
            while (i < j && p > nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }

        }
        nums[i] = p;
        if (i == f) {
            return nums[i];
        }
        if (i < f) {
            return quickSort(nums, i + 1, high, f);
        } else {
            return quickSort(nums, low, i - 1, f);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
