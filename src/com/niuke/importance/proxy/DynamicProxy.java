package com.niuke.importance.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理一个接口
 */
public class DynamicProxy {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");//保存生成的动态代理.class文件

        TargetObject targetObject = new TargetObject();
        consumer(targetObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(targetObject));

        consumer(proxy);
    }

    public static void consumer(Interface inter){
        inter.doSomething();
        inter.doSomethingElse("JackChen");
    }

    interface Interface{
        void doSomething();
        void doSomethingElse(String arg);
    }

    static class TargetObject implements Interface{
        @Override
        public void doSomething() {
            System.out.println("targetObject doSomething");
        }

        @Override
        public void doSomethingElse(String arg) {
            System.out.println("targetObject doSomethingElse");
        }
    }

    static class DynamicProxyHandler implements InvocationHandler{
        private Object target;

        public DynamicProxyHandler(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("InvocationHandler: " + proxy.getClass()
                    + ",method: " + method + ",args: " + args);
            if(args != null){
                for(Object arg : args){
                    System.out.println("InvocationHandler args: " + arg);
                }
            }
            return method.invoke(target,args);
        }
    }
}
