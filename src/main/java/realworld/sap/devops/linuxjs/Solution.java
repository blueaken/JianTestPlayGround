package realworld.sap.devops.linuxjs;

import java.io.File;

/**
 * Author: blueaken
 * Date: 7/1/16 10:07
 */
public class Solution {
    public void listFilesAndFolders(String sourceDir) {
        if (sourceDir == null) {
            System.out.println("source dir is null string");
        }

        //If sourcDir does not denote a directory, then listFiles() returns null
        File[] files = new File(sourceDir).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsoluteFile());
            }
            if (file.isDirectory()){
                listFilesAndFolders(file.getAbsolutePath());
                System.out.println("Directory: " + file.getAbsoluteFile());
            }
        }
    }

    public static void main(String[] args) {
        String test = "/Users/blueaken/Desktop";
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        solution.listFilesAndFolders(test);
        long end = System.currentTimeMillis();
        System.out.println("It takes " + (end - start) + " milli seconds.");

    }
}
