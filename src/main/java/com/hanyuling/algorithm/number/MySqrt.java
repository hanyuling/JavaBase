package com.hanyuling.algorithm.number;

public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(121));
    }

    public static int mySqrt(int x) {
        int ans = -1;
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid <= x) {
                ans = mid;
                low = mid+1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
