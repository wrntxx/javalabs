package com.education.ztu;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I love programming!!!");
        }
    }
}

public class Task2 {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread("My Thread");

        System.out.println("Thread Name: " + myThread.getName());
        System.out.println("Thread Priority: " + myThread.getPriority());
        System.out.println("Is daemon: " + myThread.isDaemon());
        System.out.println("Is alive: " + myThread.isAlive());
        System.out.println();

        System.out.println("Thread State: " + myThread.getState());
        myThread.start();
        System.out.println("Thread State: " + myThread.getState());

        myThread.setName("Updated Thread");
        myThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Thread Name: " + myThread.getName());
        System.out.println("Thread Priority: " + myThread.getPriority());
        System.out.println();

        myThread.join();
        System.out.println("Thread State " + myThread.getState());

        System.out.println("Main Thread Name: " + Thread.currentThread().getName());
        System.out.println("Main Thread Priority: " + Thread.currentThread().getPriority());
    }
}