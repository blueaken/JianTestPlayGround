package interviewprep.source1.算法与编程.two;

import java.io.*;

/**
 * Created by jianshen on 1/17/17.
 */
public class Java2Jade {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String sourceDir = "/Users/jianshen/Git/javatest/Java";
        File srcDir =new File(sourceDir);

        FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String s = pathname.getName().toLowerCase();
                if (s.endsWith(".java")) {
                    return true;
                }
                return false;
            }
        };

        File[] javaFiles = new File(sourceDir).listFiles(ff);
        if(javaFiles == null){
            System.out.println("source folder contains no Java files");
            return;
        }


        String destDir =  "/Users/jianshen/Git/javatest/Jade";
        for (File f : javaFiles) {
            FileInputStream fis = new FileInputStream(f);
            String newName = f.getName().replaceAll("\\.java$", ".jad");
            FileOutputStream fos = new FileOutputStream(new File(destDir, newName));

            copy(fis, fos);
            fis.close();
            fos.close();
        }
    }

    private static void copy(InputStream is, OutputStream os) throws IOException{
        byte[] buffer = new byte[10]; //adjust the size as needed
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
    }
}
