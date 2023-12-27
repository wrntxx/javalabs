package com.education.ztu;

class CalculationRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
                if (Thread.interrupted()) {
                    System.out.println("Calculation completed!!!");
                    return;
                }
            }
        }
    }
}

public class Task3 {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new CalculationRunnable());
        Thread thread2 = new Thread(new CalculationRunnable());
        Thread thread3 = new Thread(new CalculationRunnable());

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2000);

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}