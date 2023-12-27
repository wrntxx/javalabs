package com.education.ztu;

import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Task5 {
    public static void main(String[] args) throws Exception {
        String filePath = "task5.txt";

        try (PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);
                RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw")) {
            randomAccessFile.seek(50);
            randomAccessFile.write("[Text added at position 50]".getBytes(StandardCharsets.UTF_8));

            randomAccessFile.seek(100);
            randomAccessFile.write("[Text added at position 100]".getBytes(StandardCharsets.UTF_8));

            randomAccessFile.seek(0);
            byte[] buffer = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(buffer);

            ps.println(new String(buffer, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}