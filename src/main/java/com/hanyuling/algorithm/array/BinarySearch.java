package com.hanyuling.algorithm.array;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 7, 9, 12, 14, 16, 17, 18, 21};
        int target = 12;
        int index = binarySearch3(array, target, 0, array.length - 1);
        System.out.println(index);
        index = binarySearch4(array, target, 0, array.length - 1);
        System.out.println(index);

    }

    private static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] > target) {
            return binarySearch(array, target, low, mid);
        }
        if (array[mid] < target) {
            return binarySearch(array, target, mid, high);
        }
        if (array[mid] == target) {
            return mid;
        }
        return -1;
    }

    private static int binarySearch2(int[] array, int target, int low, int high) {
        int mid = (high + low) / 2;
        while (low < high) {
            while (low < high && array[mid] > target) {
                high = mid;
                mid = (high + low) / 2;
            }
            while (low < high && array[mid] < target) {
                low = mid;
                mid = (high + low) / 2;
            }
            if (array[mid] == target) {
                return mid;
            }
        }
        return -1;
    }


    private static int binarySearch3(int[] array,int target,int low,int high){
        if (low > high) {
            return -1;
        }
        int mid = (low+high)/2;
        if (array[mid]>target){
            return binarySearch(array, target, low, mid);
        }
        if (array[mid] < target) {
            return binarySearch(array, target, mid, high);
        }
        if (array[mid] == target) {
            return mid;
        }
        return -1;
    }

    private static int binarySearch4(int[] array,int target,int low,int high){
        int mid = (low + high) / 2;
        while (low < high) {
            while (low<high && array[mid] > target) {
                high = mid;
                mid =  (low + high) / 2;
            }
            while (low < high && array[mid] < target) {
                low = mid;
                mid =  (low + high) / 2;
            }
            if (array[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] > target) {
                left = mid+1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
