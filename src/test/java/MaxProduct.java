public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int i = maxProduct(nums);
        System.out.println(i);
    }
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(nums[i], Math.max(nums[i] * mx, nums[i] * mn));
            min = Math.min(nums[i], Math.min(nums[i] * mx, nums[i] * mn));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
