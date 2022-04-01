package com.hanyuling.algorithm.array;

import java.util.Stack;

public class MinMax {

    public static void main(String[] args) {
//        int[] nums = {6, 2, 5, 5, 5, 4, 7};
        int[] nums = { 3, 1, 6, 4, 5};
        System.out.println(maxArrayCount(nums));
    }

    public static int maxArrayCount(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                    int top = stack.pop();
                    int tmp = stack.isEmpty() ? arraySum(nums, 0, i - 1) : arraySum(nums, stack.peek() + 1, i - 1);
                    int curSum = nums[top] * tmp;
                    max = Math.max(curSum, max);
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int tmp = stack.isEmpty() ? arraySum(nums, 0, n - 1) : arraySum(nums, stack.peek() + 1, n - 1);
            int curSum = nums[top] * tmp;
            max = Math.max(curSum, max);
        }
        return max;
    }

    private static int arraySum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
