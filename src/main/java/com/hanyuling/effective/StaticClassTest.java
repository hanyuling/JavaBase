package com.hanyuling.effective;

public class StaticClassTest {

    public  class InnerStaticClass{

    }

    public static void main(String[] args) {
        StaticClassTest staticClassTest = new StaticClassTest();
        InnerStaticClass innerStaticClass= staticClassTest.new InnerStaticClass();
    }
}
