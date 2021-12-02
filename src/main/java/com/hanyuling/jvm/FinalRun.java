package com.hanyuling.jvm;

import java.util.LinkedList;
import java.util.List;

public class FinalRun {

    public final String str;

    public FinalRun(String str, List<FinalRun> list) {
        list.add(this);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.str = str;
    }

    public void get(){
        System.out.println(str);
    }

    public static void main(String[] args) {
        List<FinalRun> list = new LinkedList<>();
        Thread thread = new Thread(){
            @Override
            public void run() {
                FinalRun run = new FinalRun("aa", list);
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.get(0).get();
        System.out.println(list.get(0).str);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0).str);
    }
}
