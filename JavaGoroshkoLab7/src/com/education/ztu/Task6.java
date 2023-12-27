package com.education.ztu;

import java.util.Scanner;

class Data {
    private String message;
    private boolean newDataAvailable = false;

    public synchronized void write(String message) {
        while (newDataAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        newDataAvailable = true;

        this.message = message;
        notify();
    }

    public synchronized String read() {
        while (!newDataAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        newDataAvailable = false;

        notify();
        return message;
    }
}

class Reader extends Thread {
    private final Data data;
    private final Scanner scanner;

    public Reader(Data data, Scanner scanner) {
        this.data = data;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("Input: ");
            data.write(scanner.nextLine());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Printer extends Thread {
    private final Data data;

    public Printer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Printing: " + data.read());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Task6 {
    public static void main(String[] args) throws Exception {
        Data data = new Data();
        Scanner scanner = new Scanner(System.in);

        Thread readerThread = new Reader(data, scanner);
        Thread printerThread = new Printer(data);

        readerThread.start();
        printerThread.start();
    }
}