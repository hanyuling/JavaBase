package com.hanyuling.jvm;

import java.time.LocalDate;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("aa start...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1 / 0);
                System.out.println("aa is park..");
                LockSupport.park();
                System.out.println("aa is run...");
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("bb start...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("bb is park..");
                LockSupport.park();
                System.out.println("bb is run...");
            }
        };
        t1.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println(t);
            System.out.println(e);
        });
        t1.start();
        LockSupport.unpark(t1);
        System.out.println("ggggggggg");
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t2);

    }
}
