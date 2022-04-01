package com.hanyuling.algorithm.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 2) {
            return;
        }
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            for (int j = 2; j <= i; j++) {
                if (flag[j] == false) {
                    continue;
                }
                if (j * i >= n) {
                    break;
                }
                flag[j * i] = false;
            }
            if (flag[i] == true) {
                list.add(i);
                System.out.println(i);
            }
        }


    }
}
