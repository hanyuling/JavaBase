package com.hanyuling.algorithm.array;

import java.util.HashSet;
import java.util.Set;

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

    public static int majorityElement2(int[] nums) {
        int count = 0;
        Integer tmp = null;
        for (int num : nums) {
            if (count == 0) {
                tmp = num;
            }
            count += (tmp == num ? 1 : -1);
        }
       
        return tmp;
    }
}
