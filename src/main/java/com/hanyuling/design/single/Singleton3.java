package com.hanyuling.design.single;

public class Singleton3 {
    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return Instance.INSTANCE;
    }

    private static class Instance{
        private static Singleton3 INSTANCE = new Singleton3();
    }
}
