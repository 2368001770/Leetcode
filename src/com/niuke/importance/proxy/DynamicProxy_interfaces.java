package com.niuke.importance.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理一组接口
 */
public class DynamicProxy_interfaces {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        try{
            TargetObject targetObject = new TargetObject();
            InvocationHandler invocationHandler = new DynamicProxyHandler(targetObject);
            Class<?> clazz = Proxy.getProxyClass(TargetObject.class.getClassLoader(),
                    new Class[]{InterfaceB.class,InterfaceA.class});
            Constructor<?> constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
            InterfaceA proxy_a = (InterfaceA) constructor.newInstance(invocationHandler);
            InterfaceB proxy_b = (InterfaceB) constructor.newInstance(invocationHandler);
            proxy_a.doSomething();
            proxy_a.doA();
            proxy_b.doSomething();
            proxy_b.doB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public interface InterfaceA {
        void doSomething();
        void doA();
    }

    public interface InterfaceB {
        void doSomething();
        void doB();
    }

    static class TargetObject implements InterfaceA,InterfaceB {
        @Override
        public void doSomething() {
            System.out.println("targetObject doSomething");
        }

        @Override
        public void doB() {
            System.out.println("targetObject doB");
        }

        @Override
        public void doA() {
            System.out.println("targetObject doA");
        }
    }

    static class DynamicProxyHandler implements InvocationHandler {
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