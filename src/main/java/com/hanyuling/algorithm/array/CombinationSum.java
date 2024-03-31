package com.hanyuling.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wrg
 * @date: 2024/3/29 14:30
 */
public class CombinationSum {


    /**
     * leecode 39
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(candidates, target, res, ans, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> ans, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        dfs(candidates, target, res, ans, idx + 1);

        if (target - candidates[idx] >= 0) {
            ans.add(candidates[idx]);
            dfs(candidates, target-candidates[idx], res, ans, idx);
            ans.remove(ans.size() - 1);
        }
    }

}
