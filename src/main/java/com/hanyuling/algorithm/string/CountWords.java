package com.hanyuling.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountWords {
    // mysql redis mysql redis redis java
    // 统计次数，倒叙输出
    public static void main(String[] args) {
        String s = "mysql redis mysql redis redis java";

        countWords(s);
    }

    public static void countWords(String line) {
        Map<String, Integer> map = new HashMap<>();
        String[] word = line.split(" ");
        for (int i = 0; i < word.length; i++) {
            Integer count = map.getOrDefault(word[i], 0);
            count++;
            map.put(word[i], count);
        }
        int length = map.keySet().size();
        String[] strings = new String[length];
        int[] counts = new int[length];
        for (String wd : map.keySet()) {
            Integer integer = map.get(wd);
            for (int i = 0; i < word.length; i++) {
                if (integer > counts[i]) {
                    System.arraycopy(counts, i, counts, i + 1, length - 1 - i);
                    System.arraycopy(strings, i, strings, i + 1, length - 1 - i);
                    counts[i] = integer;
                    strings[i] = wd;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(counts));
        System.out.println(Arrays.toString(strings));
    }
}
