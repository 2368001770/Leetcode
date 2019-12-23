package com.niuke.test;

public class A {
    int a,b;

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public A(int a) {
        this(a,10);
        this.a = a;
    }
}
