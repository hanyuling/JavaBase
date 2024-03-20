package com.hanyuling.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: wrg
 * @date: 2024/3/19 19:30
 */
public class LockUpdate {


    public static void main(String[] args) {
        lockUpgradeTest1();
    }
    public static void lockUpgradeTest1() {
        Object obj = new Object();
        System.out.println("未开启偏向锁，对象信息");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj) {
            System.out.println("已获取到锁信息");
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
        System.out.println("已释放锁信息");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

}
