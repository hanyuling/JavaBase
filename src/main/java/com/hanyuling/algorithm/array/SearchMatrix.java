package com.hanyuling.algorithm.array;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] matrix = {{-1, 3}};
        boolean b = searchMatrix2(matrix, 12);
        System.out.println(b);

    }

    public static boolean searchMatrix2(int[][] matrix, int target){
       int row = matrix.length-1;
       int clo = 0;
        while (row >= 0 && clo <= matrix[0].length - 1) {
            if (target > matrix[row][clo]) {
                clo++;
            } else if (target < matrix[row][clo]) {
                row--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        boolean flag = true;
        int i = 0;
        int j = 0;
        while (i < matrix.length && i >= 0 && j < matrix[0].length && j >= 0) {
            int tmp = matrix[i][j];
            if (tmp == target) {
                return true;
            }
            if (flag) {
                if (tmp < target) {
                    i++;
                    if (i == matrix.length){
                        i--;
                        j++;
                        flag = false;
                    }
                } else {
                    i--;
                    flag = false;
                }
            } else {
                if (tmp < target) {
                    j++;
                } else {
                    flag = true;
                    i--;
                }
            }
        }
        return false;
    }
}
