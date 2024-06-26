package com.hanyuling.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        mergeSort(SortUtils.nums);
        System.out.println(Arrays.toString(SortUtils.nums));
    }


    /**
     * 总体时间复杂度：O(n)+O(nlogn)
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n+logn)
     * 稳定
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        mSort(nums, nums, 0, nums.length - 1);
    }

    private static void mSort(int[] sr, int[] tr, int s, int t) {
        int m;
        int[] tr2 = new int[sr.length];
        if (s == t) {
            tr[s] = sr[s];
        } else {
            m = (s + t) / 2; // 将sr[s..t]平分为sr[s..m]和sr[m+1..t]
            mSort(sr, tr2, s, m);// 递归将sr[s..m]归并为有序的tr2[s..m]
            mSort(sr, tr2, m + 1, t);// 递归将sr[m+1..t]归并为有序的tr2[m+1..t]
            merge(tr2, tr, s, m, t); // 将tr2[s..m]和tr2[m+1..t]归并到tr[s..t]
        }
    }

    private static void merge(int[] sr, int[] tr, int i, int m, int n) {
        int j, k, l;
        for (j = m + 1, k = i; i <= m && j <= n; k++) {
            if (sr[i] < sr[j]) {
                tr[k] = sr[i++];
            } else {
                tr[k] = sr[j++];
            }
        }
        if (i <= m) {
            for (l = i; l <= m; l++) {
                tr[k++] = sr[l];
            }
        }
        if (j <= n) {
            for (l = j; l <= n; l++) {
                tr[k++] = sr[l];
            }
        }
    }


}
