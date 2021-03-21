package com.mashibing;

import java.time.temporal.ValueRange;

public class CommonDemo {

    public static void main(String[] args) {
        // testAB();


    }

    //test:强制转换引用传递
    private static void testAB() {
        A a = new B();
        a.setA("this is b2a");

        B b = (B) a;
        b.setA("this is b");

        System.out.println(a.getA());
    }
}

class A {
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}

class B extends A {
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
