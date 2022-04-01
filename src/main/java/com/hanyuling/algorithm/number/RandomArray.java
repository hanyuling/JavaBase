package com.hanyuling.algorithm.number;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {

    int[] nums ;
    int[] original;

    public RandomArray(int[] nums) {
        this.nums = nums;
        original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length - i);
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        RandomArray ra = new RandomArray(new int[]{1,4,6,3,7});
        System.out.println(Arrays.toString(ra.shuffle()));
    }
}
