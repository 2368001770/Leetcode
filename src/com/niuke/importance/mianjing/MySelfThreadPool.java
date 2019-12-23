package com.niuke.importance.mianjing;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 手写线程池
 * https://blog.csdn.net/hongtaolong/article/details/87808009
 */
public class MySelfThreadPool {
    private static final int WORK_NUM = 5;

    private static final int TASK_NUM = 100;

    private int workNum;

    private int taskNum;

    private final Set<WorkThread> workThreads;

    private final BlockingQueue<Runnable> taskQueue;

    public MySelfThreadPool() {
        this(WORK_NUM,TASK_NUM);
    }

    public MySelfThreadPool(int workNum,int taskNum){
        if(workNum <= 0){
            workNum = WORK_NUM;
        }
        if(taskNum <= 0){
            taskNum = TASK_NUM;
        }
        taskQueue = new ArrayBlockingQueue<>(taskNum);
        this.workNum = workNum;
        this.taskNum = taskNum;
        workThreads = new HashSet<>();
        for(int i=0;i<workNum;i++){
            WorkThread workThread = new WorkThread("thread_"+i);
            workThread.start();
            workThreads.add(workThread);
        }
    }

    public void execute(Runnable task){
        try{
            taskQueue.put(task);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void destroy(){
        System.out.println("ready close thred pool...");
        if(workThreads == null || workThreads.isEmpty()){
            return ;
        }
        for(WorkThread workThread : workThreads){
            workThread.stopWork();
            workThread = null;
        }
        workThreads.clear();
    }

    private class WorkThread extends Thread{
        public WorkThread(String name){
            super();
            setName(name);
        }

        public void run(){
            while(!interrupted()){
                try{
                    Runnable runnable = taskQueue.take();
                    if(runnable != null){
                        System.out.println(getName() + " ready execute:"+runnable.toString());
                        runnable.run();
                    }
                    runnable = null;
                }catch (InterruptedException e){
                    interrupt();
                    e.printStackTrace();
                }
            }
        }

        public void stopWork(){
            interrupt();
        }
    }

    static class TestMySelfThreadPool{
        private static final int TASK_NUM = 50;

        public static void main(String[] args) {
            MySelfThreadPool mySelfThreadPool = new MySelfThreadPool(3,50);
            for(int i=0;i<TASK_NUM;i++){
                mySelfThreadPool.execute(new MyTask("task_"+i));
            }
        }

        static class MyTask implements Runnable{

            private String name;
            public MyTask(String name){
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task :"+name+" end...");
            }

            @Override
            public String toString() {
                return "name = " + name;
            }
        }
    }
}
