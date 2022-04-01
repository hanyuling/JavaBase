package com.hanyuling.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PermuteArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>(n);
        for (int num : nums) {
            output.add(num);
        }
        backtrack(n, output, res, 0);
        return res;

    }

    private static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (n == first) {
            res.add(new ArrayList<>(output));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(output, i, first);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, i, first);
        }
    }
}
