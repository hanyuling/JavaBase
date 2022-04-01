import com.hanyuling.algorithm.sort.SortUtils;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        heapSort(nums);
        quickSort(nums);
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
//        mergeSort(SortUtils.nums);
//        heapSort(SortUtils.nums);
//        quickSort(SortUtils.nums);
        System.out.println(Arrays.toString(SortUtils.nums));
    }


    private static void mergeSort(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        partitionAndSort(nums, low, high);
    }

    private static void partitionAndSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        partitionAndSort(nums, low, mid);
        partitionAndSort(nums, mid + 1, high);
        merge(nums, low,mid,high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            }else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= mid) {
            tmp[k++] = nums[i++];
        }
    }

    private static void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums, low, high);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high;
        int p = nums[i];
        while (i < j) {
            while (i < j && p <= nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && p > nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = p;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    private static void heapSort(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            adjustHeap(nums,0,i-1);
        }
    }

    private static void adjustHeap(int[] nums, int n, int m) {
        int p = nums[n];
        for (int i = 2 * n + 1; i <= m; i = 2 * i + 1) {
            if (i + 1 <= m && nums[i + 1] > nums[i]) {
                i++;
            }
            if (p > nums[i]) {
                break;
            }
            nums[n] = nums[i];
            n = i;
        }
        nums[n] = p;
    }


}
