package com.hanyuling.algorithm.array;

import java.util.Arrays;

public class MergeArray {

    //

    public static void main(String[] args) {
        int[] a = {3, 5, 6, 7}, b = {2, 3, 5, 9, 10};
        int[] array = mergeArray(a, b);
        System.out.println(Arrays.toString(array));
    }

    public static int[] mergeArray(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] result = new int[aLen + bLen];
        int index = 0;
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < aLen && bIndex < bLen) {
            if (a[aIndex] < b[bIndex]) {
                result[index++] = a[aIndex++];
            } else {
                result[index++] = b[bIndex++];
            }
        }
        if (aIndex < aLen) {
            for (int i = aIndex; i < aLen; i++) {
                result[index++] = a[i];
            }
        }
        if (bIndex < bLen) {
            for (int i = bIndex; i < bLen; i++) {
                result[index++] = b[i];
            }
        }
        return result;
    }
}
