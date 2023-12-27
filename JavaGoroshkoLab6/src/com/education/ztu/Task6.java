package com.education.ztu;

import java.io.File;

public class Task6 {
    public static void main(String[] args) throws Exception {
        try {
            File innerDirectory = new File("inner_directory");
            if (!innerDirectory.exists() && !innerDirectory.mkdir()) {
                throw new Exception("Failed to create folder inner_directory.");
            }
            System.out.println("Folder inner_directory created successfully.");

            System.out.println("Absolute path of the inner_directory folder: " + innerDirectory.getAbsolutePath());
            
            System.out.println("Name of the parent directory: " + innerDirectory.getParent());

            File file1 = new File(innerDirectory, "file1.txt");
            File file2 = new File(innerDirectory, "file2.txt");

            if (!file1.createNewFile()) {
                throw new Exception("Failed to create file1.txt.");
            }
            if (!file2.createNewFile()) {
                throw new Exception("Failed to create file2.txt.");
            }
            System.out.println("Text files created successfully.");

            if (!file1.delete()) {
                throw new Exception("Failed to delete file file1.txt.");
            }
            System.out.println("File file1.txt deleted successfully.");

            File renamedDirectory = new File("renamed_inner_directory");
            if (!innerDirectory.renameTo(renamedDirectory)) {
                throw new Exception("Failed to rename folder inner_directory.");
            }
            System.out.println("Folder inner_directory renamed to renamed_inner_directory.");

            File directoryForFiles = new File("directory_for_files");
            if (!directoryForFiles.exists() && !directoryForFiles.mkdir()) {
                throw new Exception("Failed to create folder directory_for_files.");
            }
            System.out.println("Folder directory_for_files created successfully.");

            int numberOfFiles = 3;
            int numberOfFolders = 2;

            for (int i = 0; i < numberOfFiles; i++) {
                File file = new File(directoryForFiles, String.format("file%d.txt", i + 1));
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
            for (int i = 0; i < numberOfFolders; i++) {
                File file = new File(directoryForFiles, String.format("folder%d", i + 1));
                if (!file.exists()) {
                    file.mkdir();
                }
            }

            File[] filesAndFolders = directoryForFiles.listFiles();

            if (filesAndFolders != null) {
                System.out.println("List of files and folders in the directory_for_files folder:");
                for (File fileOrFolder : filesAndFolders) {
                    System.out.println("Name: " + fileOrFolder.getName());
                    System.out.println("Size: " + fileOrFolder.length() + " bytes");
                    System.out.println("Type: " + (fileOrFolder.isDirectory() ? "Folder" : "File"));
                    System.out.println();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}