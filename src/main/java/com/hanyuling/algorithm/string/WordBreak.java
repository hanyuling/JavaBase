package com.hanyuling.algorithm.string;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordBreak {



    public static boolean wordBreak(String s, List<String> wordDict) {
        Set wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> list = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
        List<String> res = new LinkedList<>();
        for (List<String> strs : list) {
            String join = String.join(" ", strs);
            res.add(join);
        }
        return res;
    }

    private static List<List<String>> backtrack(String s, int length, HashSet<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> breakLists = new LinkedList<>();
            if (index == length) {
                breakLists.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextBacktrack = backtrack(s, length, wordSet, i, map);
                    for (List<String> strings : nextBacktrack) {
                        LinkedList<String> breakList = new LinkedList<>(strings);
                        breakList.addFirst(word);
                        breakLists.add(breakList);
                    }
                }

            }
            map.put(index, breakLists);
        }
        return map.get(index);
    }

    public static void arraySort(int[] arr) {
        int index = arr.length - 1;
        int count = 0;
        while (index >= 0) {
          if (arr[index]==0){
              count++;
          }else {
              arr[index+count] = arr[index];
          }
            index--;
        }
        for (int i = 0; i < count; i++) {
            arr[i]=0;
        }
        ConcurrentMap map = new ConcurrentHashMap();
    }
    public static void main(String[] args) {
//        String s = "catsanddog";
//        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
//        List<String> list = List.of(wordDict);
//        System.out.println(list);
//        System.out.println(wordBreak2(s, list));

        int[] aa = {0,2,6,0,4,7,0,4,5,0};
        arraySort(aa);
        System.out.println(Arrays.toString(aa));
    }

}
