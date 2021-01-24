package com.cedar.concurrency.art;

/**
 * @author zhangnan
 * @date 2021/1/21 18:26
 */
public class ThreadStatus {


    public static void main(String[] args) {

        new Thread(new TimeWaiting(), "TimeWaitingThread").start();

        new Thread(new Waiting(), "WaitingThread").start();

        new Thread(new Blocked(), "BlockThread-1").start();

        new Thread(new Blocked(), "BlockThread-2").start();

    }

    static class TimeWaiting implements Runnable {


        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }


    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }


}
