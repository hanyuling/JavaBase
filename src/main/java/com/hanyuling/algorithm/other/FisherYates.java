package com.hanyuling.algorithm.other;

import java.util.Random;

public class FisherYates {
    int[] original;
    int[] nums;
    Random random = new Random();

    public FisherYates(int[] nums) {
        this.nums = nums.clone();
        original = nums;
    }

    public int[] reset() {
        return original.clone();
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, randRange(i, nums.length));
        }
        return nums;
    }

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
