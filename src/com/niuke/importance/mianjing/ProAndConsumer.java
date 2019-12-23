package com.niuke.importance.mianjing;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 使用wait和notify/notifyAll来实现
 * @param <T>
 */
public class ProAndConsumer<T> {
    private final List<T> list = new LinkedList<T>();
    private final int MAX = 10;

    public synchronized T consume(){
        T t = null;
        while(list.size() == 0){
            try{
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.remove(0);
        System.out.println(Thread.currentThread().getName() + "consume: " + t);
        notifyAll();
        //notify();       死锁
        return t;
    }

    public synchronized void put(T t){
        while(list.size() == MAX){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        list.add(t);
        System.out.println(Thread.currentThread().getName() + "produce: " + t);
        notifyAll();
        //notify();        死锁
    }

    public static void main(String[] args) {
        ProAndConsumer<String> proAndConsumer = new ProAndConsumer<>();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<5;j++){
                    proAndConsumer.consume();
                    //System.out.println(proAndConsumer.consume());
                }
            },"Consumer"+i).start();
        }

        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    proAndConsumer.put(Thread.currentThread().getName() + " " + j);
                }
            },"Producer"+i).start();
        }
    }
}
