package com.hanyuling.jvm;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: wrg
 * @date: 2024/3/25 16:06
 */
public class WaitAndNotify {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        AtomicBoolean flag = new AtomicBoolean(false);
        Thread t1= new Thread(()->{
            synchronized (lock) {
                while (true){
                    System.out.println("a");
                    if (!flag.get()) {
                        flag.set(true);
                    }
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        Thread t2= new Thread(()->{
            synchronized (lock) {
                while (true) {
                    System.out.println("b");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        if (flag.get()) {
            t2.start();
        }

        Thread.sleep(100000);

    }

}
