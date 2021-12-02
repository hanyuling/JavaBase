package com.hanyuling.jvm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SyncTest {

    public static void main(String[] args) {
//        SyncTest test = new SyncTest();
//        Map<String, Integer> map = new HashMap<>();
//        map.put("aa", 0);
//        map.put("bb", 0);
//        map.put("cc", 0);
//        map.put("dd", 0);
//        Thread[] threads1 = new Thread[10];
//
//
//        for (int i = 0; i < threads1.length; i++) {
//            threads1[i] = new Thread() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 1000000; i++) {
//                        test.add(map, "aa");
//                    }
//                }
//            };
//        }
//        Thread[] threads2 = new Thread[10];
//        for (int i = 0; i < threads2.length; i++) {
//            threads2[i] = new Thread() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 1000000; i++) {
//                        test.add(map, "bb");
//                    }
//                }
//            };
//        }
//        Thread[] threads3 = new Thread[10];
//        for (int i = 0; i < threads3.length; i++) {
//            threads3[i] = new Thread() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 1000000; i++) {
//                        test.add(map, "cc");
//                    }
//                }
//            };
//        }
//        Thread[] threads4 = new Thread[10];
//        for (int i = 0; i < threads4.length; i++) {
//            threads4[i] = new Thread() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 1000000; i++) {
//                        test.add(map, "dd");
//                    }
//                }
//            };
//        }
//        long start = System.currentTimeMillis();
//        List<Thread> list = new ArrayList<>();
//        list.addAll(Arrays.asList(threads1));
//        list.addAll(Arrays.asList(threads2));
//        list.addAll(Arrays.asList(threads3));
//        list.addAll(Arrays.asList(threads4));
//        list.forEach(Thread::start);
//        for (Thread thread : list) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        System.out.println(map);
        String aa="sdasd";
        String bb = aa.intern();
        System.out.println(aa == bb);

    }

    public void add(Map<String, Integer> map, String key) {
        add2(map, key);
    }

    public void add1(Map<String, Integer> map, String key) {
        synchronized (key) {
            Integer integer = map.get(key);
            integer++;
            map.put(key, integer);
        }
    }

    public void add2(Map<String, Integer> map, String key) {
        synchronized (this) {
            Integer integer = map.get(key);
            integer++;

            map.put(key, integer);
        }
    }

}
