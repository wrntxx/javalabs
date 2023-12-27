package com.education.ztu;

class IncrementBlockRunnable implements Runnable {
    private static Integer result = 1;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (result) {
                System.out.print(result + " ");
                result++;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class Task5 {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new IncrementBlockRunnable());
        Thread thread2 = new Thread(new IncrementBlockRunnable());
        Thread thread3 = new Thread(new IncrementBlockRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}