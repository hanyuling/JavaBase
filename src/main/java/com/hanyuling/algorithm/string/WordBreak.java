package com.hanyuling.algorithm.string;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordBreak {


    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (wordDict.contains(s.substring(j, i)) && flag[j]) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }

    public static List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<LinkedList<String>>> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        List<LinkedList<String>> list = backTrace(s, s.length(), set, 0, map);
        List<String> result = new ArrayList<>();
        for (List<String> strings : list) {
            String join = String.join(" ", strings);
            result.add(join);
        }
        return result;
    }

    private static List<LinkedList<String>> backTrace(String s, int length, Set<String> set, int index, Map<Integer, List<LinkedList<String>>> map) {
        if (map.get(index) == null) {
            List<LinkedList<String>> list = new LinkedList<>();
            if (index == length){
                list.add(new LinkedList<>());
                return list;
            }
            for (int i = index+1; i <= s.length(); i++) {
                if (set.contains(s.substring(index,i))){
                    List<LinkedList<String>> lists = backTrace(s, length, set, i, map);
                    for (LinkedList<String> strings : lists) {
                        LinkedList<String> strings1 = new LinkedList<>();
                        strings1.addAll(strings);
                        strings1.addFirst(s.substring(index,i));
                        list.add(strings1);
                    }
                }
            }
            map.put(index, list);
        }
        return map.get(index);
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
//        String s = "leetcode";
//        String[] wordDict = {"leet", "code"};
        List<String> list = List.of(wordDict);
        System.out.println(wordBreak2(s, list));


    }

}
