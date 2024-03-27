package com.hanyuling.jvm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wrg
 * @date: 2024/3/25 17:31
 */
public class ThreadPrint {

     int num = 0;
    static final Object LOCK = new Object();

    public static void main(String[] args) {
//        ThreadPrint print = new ThreadPrint();
//
//        Thread t1 = new Thread(()->{
//            print.printABCwithNotify(0);
//        });
//        t1.start();
//        Thread t2 = new Thread(()->{
//            print.printABCwithNotify(1);
//        });
//        t2.start();

//        for (int i = 0; i < 10; i++) {
//            Thread t1 = new Thread(()->new ThreadPrint().printABCWithJoin(null));
//            Thread t2 = new Thread(()->new ThreadPrint().printABCWithJoin(t1));
//            t1.start();
//            t2.start();
//        }

        Thread t1 = new Thread(()->new ThreadPrint().printAbcWithCondition(c1,c2));
         Thread t2 = new Thread(()->new ThreadPrint().printAbcWithCondition(c2,c1));
         t1.start();
         t2.start();

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private  void printABCwithNotify(int targetNum) {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                while (num % 2 == targetNum) {
                    System.out.println(Thread.currentThread().getName() + targetNum);
                    num++;
                }
                LOCK.notify();
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Thread pre = null;

    private void printABCWithJoin(Thread pre) {
        this.pre = pre;
        try {
            if (pre != null) {
                pre.join();
            }
            System.out.println(Thread.currentThread().getName()+"=====>");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static ReentrantLock reLock = new ReentrantLock();
    static Condition c1 = reLock.newCondition();
    static Condition c2 = reLock.newCondition();

    private void printAbcWithCondition(Condition cur, Condition next) {
        while (true) {
            reLock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
                next.signal();
                    cur.await();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                reLock.unlock();
            }

        }
    }
}
