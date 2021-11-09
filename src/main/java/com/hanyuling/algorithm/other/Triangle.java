package com.hanyuling.algorithm.other;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList();
        List<Integer> clist = new ArrayList<>(1);
        clist.add(1);
        list.add(clist);
        for (int i = 1; i < numRows; i++) {
            List<Integer> hlist = new ArrayList(i + 1);
            for (int j = 0; j < i + 1; j++) {
                Integer left = 0;
                if (j - 1 >= 0) {
                    left = clist.get(j - 1);
                }
                Integer right = 0;
                if (j < clist.size()) {
                    right = clist.get(j);
                }
                hlist.add(left + right);
            }
            list.add(hlist);
            clist = hlist;
        }
        return list;
    }
}
