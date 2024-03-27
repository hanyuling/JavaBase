package com.hanyuling.algorithm.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * leecode 1438
 *
 * @author: wrg
 * @date: 2024/3/25 11:39
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
