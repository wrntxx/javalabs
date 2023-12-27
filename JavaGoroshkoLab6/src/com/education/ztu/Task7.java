package com.education.ztu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Task7 {
    public static void main(String[] args) throws Exception {
        String sourceDirectoryPath = "directory_for_files";
        String archiveFilePath = "directory_for_files.zip";

        createArchive(sourceDirectoryPath, archiveFilePath);
        printArchive(archiveFilePath);
    }

    private static void createArchive(String sourceDirectoryPath, String archiveFilePath) {
        File sourceDirectory = new File(sourceDirectoryPath);
        if (!sourceDirectory.exists()) {
            System.out.println("Failed to find source directory.");
            return;
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(archiveFilePath))) {
            archiveFiles(sourceDirectory, sourceDirectory, zipOutputStream);
            zipOutputStream.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }            
    }

    private static void archiveFiles(File sourceDirectory, File currentFile, ZipOutputStream zipOutputStream) throws Exception {
        String relativePath = sourceDirectory.toURI().relativize(currentFile.toURI()).getPath();
        zipOutputStream.putNextEntry(new ZipEntry(relativePath));

        if (currentFile.isDirectory()) {
            File[] files = currentFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    archiveFiles(sourceDirectory, file, zipOutputStream);
                }
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(currentFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, length);
                }
                zipOutputStream.closeEntry();
            }
        }
    }

    private static void printArchive(String archiveFilePath) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archiveFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                System.out.println("File: " + entry.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}