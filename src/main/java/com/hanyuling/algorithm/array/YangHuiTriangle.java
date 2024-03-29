package com.hanyuling.algorithm.array;

import java.util.Arrays;

/**
 * @author: wrg
 * @date: 2024/3/28 20:23
 */
public class YangHuiTriangle {


    public static void main(String[] args) {
        int[][] ints = printTriangle(7);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }

    public static int[][] printTriangle(int n) {
        int[][] trangle = new int[n][];

        for (int i = 0; i < n; i++) {
            trangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || i == j) {
                    trangle[i][j] = 1;
                }else {
                    trangle[i][j] = trangle[i - 1][j - 1] + trangle[i-1][j];
                }
            }
        }
        return trangle;
    }
}
