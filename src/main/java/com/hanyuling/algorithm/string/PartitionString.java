package com.hanyuling.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wrg
 * @date: 2024/3/20 21:15
 */
public class PartitionString {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }


    List<List<String>> res = new ArrayList<>();
    List<String> ans2 = new ArrayList<>();
    boolean[][] f2 ;
    int n2;

    public List<List<String>> patition(String s) {
        n2 = s.length();
        f2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f2[i], true);
        }

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i + 1; j < n; j++) {
                f2[i][j] = f2[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfs2(s, 0);
        return res;
    }

    private void dfs2(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (f2[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
