package com.hanyuling.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SplitPalindrome {

    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i], true);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i + 1][j - 1];
            }
        }
        dfs(s, flag, 0, s.length());
        return res;
    }

    private void dfs(String s, boolean[][] flag, int i, int length) {
        if (i == length) {
            res.add(new ArrayList<>(ans));
            return;
        }
            for (int j = i; j < length; j++) {
                if (flag[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, flag, j + 1, length);
                    ans.remove(ans.size()-1);
                }
            }
    }


    public static void main(String[] args) {

        String s = "aab";
        SplitPalindrome sp = new SplitPalindrome();
        List<List<String>> partition = sp.partition(s);
        System.out.println(partition);
    }
}
