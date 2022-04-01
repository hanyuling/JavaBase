package com.hanyuling.algorithm.array;

import java.util.Arrays;

public class MergeArrayRange {


    public static void main(String[] args) {
        int[][] nums = {{1, 4}, {4, 6},{7,8},{2,3},{9,10}};
        int[][] merge = merge(nums);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
        System.out.println();
        Arrays.sort(merge, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }

    }

    public static int[][] merge(int[][] intervals) {

        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
                    if (intervals[i][0] < intervals[j][0]) {
                        intervals[j][0] = intervals[i][0];
                    }
                    if (intervals[i][1] > intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    intervals[i] = null;
                    count++;
                    break;
                }
            }
        }
        int[][] res = new int[intervals.length-count][2];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                res[index++] = intervals[i];
            }
        }
        return res;
    }
}
