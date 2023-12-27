package com.education.ztu;

class IncrementRunnable implements Runnable {
    private static Integer result = 1;

    private static synchronized void incrementResult() {
        result++;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(result + " ");
            incrementResult();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class Task4 {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new IncrementRunnable());
        Thread thread2 = new Thread(new IncrementRunnable());
        Thread thread3 = new Thread(new IncrementRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}