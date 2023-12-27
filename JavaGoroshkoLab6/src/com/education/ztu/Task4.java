package com.education.ztu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Task4 {
    public static void main(String[] args) throws Exception {
        String sourceFilePath = "text.txt";
        String destinationFilePath = "text_copy.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath, StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sourceImagePath = "image.jpg";
        String destinationImagePath = "image_copy.jpg";

        try (FileInputStream inputStream = new FileInputStream(sourceImagePath);
             FileOutputStream outputStream = new FileOutputStream(destinationImagePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}