package com.hanyuling.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SplitPalindrome {
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    boolean[][] f;
    public List<List<String>> partition(String s){
        n=s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],true);
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j < n; j++) {
                f[i][j]=(s.charAt(i)==s.charAt(j))&&f[i+1][j-1];
            }
        }
        System.out.println(Arrays.toString(f[0]));
        System.out.println(Arrays.toString(f[1]));
        System.out.println(Arrays.toString(f[2]));
       dfs(s , 0);
        return ret;
    }

    private void dfs(String s, int i) {
        if (i == n){
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < n; j++) {
            if (f[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }


    public static void main(String[] args) {

        String s = "baa";
        SplitPalindrome sp = new SplitPalindrome();
        List<List<String>> partition = sp.partition(s);
        System.out.println(partition);
    }
}
