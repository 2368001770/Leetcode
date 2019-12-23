package com.niuke.importance.proxy;

public class StaticProxy {

    public static void main(String[] args) {
        consumer(new TargetObject());
        consumer(new SimpleProxy(new TargetObject()));
    }

    public static void consumer(Interface inter){
        inter.doSomething();
        inter.doSomethingElse("JackChen");
    }

    /**
     * 公共接口
     */
    interface Interface{
        void doSomething();
        void doSomethingElse(String arg);
    }

    /**
     * 目标对象
     */
    static class TargetObject implements Interface{

        @Override
        public void doSomething() {
            System.out.println("target doSomething");
        }

        @Override
        public void doSomethingElse(String arg) {
            System.out.println("target doSomethingElse " + arg);
        }
    }

    /**
     * 代理对象
     */
    static class SimpleProxy implements Interface{

        Interface targetObject;

        public SimpleProxy(Interface targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public void doSomething() {
            System.out.println("simpleProxy doSomething");
            targetObject.doSomething();
        }

        @Override
        public void doSomethingElse(String arg) {
            System.out.println("simpleProxy doSomethingElse " + arg);
            targetObject.doSomethingElse(arg);
        }
    }
}
