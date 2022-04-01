package com.hanyuling.algorithm.array;

public class MajorityElement {

    public static void main(String[] args) {
        int[] aa = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(aa));
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }
}
