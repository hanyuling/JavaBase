package com.hanyuling.algorithm.linklist;

import java.util.*;

public class ListFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bbbb");
        list.add(null);
        list.add("cc");
        list.add("dd");
        list.stream().filter(Objects::nonNull).forEach(System.out::println);
        Set<String> set = new HashSet<>();
        System.out.println(set.add("aa"));
        System.out.println(set.add("aa"));
        long count = list.stream().filter(Objects::nonNull).count();
        System.out.println(count);
        boolean flag = !true;
        System.out.println(flag);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.DATE, 180);
        System.out.println(calendar.getTime());
        String join = String.join(",", list);
        System.out.println(join);
    }
}
