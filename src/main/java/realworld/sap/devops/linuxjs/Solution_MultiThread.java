package realworld.sap.devops.linuxjs;

import java.io.File;
import java.util.concurrent.*;

/**
 * Author: blueaken
 * Date: 7/4/16 11:25
 */
public class Solution_MultiThread {
    public static void main(String[] args) {
        String test = "/Users/blueaken/Desktop";
        Solution solution = new Solution();
        solution.listFilesAndFolders(test);

        long start = System.currentTimeMillis();

        final int threadCount = 10;

        // BlockingQueue with a capacity of 200
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        // create thread pool with given size
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        // start CPUTask/Consumer multi threads first, so as to start working as soon as there is new
        // entry in the blocking queue
        for (int i = 0; i < threadCount; i++) {
            service.submit(new CPUTask(queue));
        }

        // start FileTask/Producer thread next
        FileTask fileTask = new FileTask(queue);
        service.submit(fileTask);

        // interrupt CPUTasks/Consumer since Producer job is done
        service.shutdownNow();

        // Wait til CPUTasks/Consumer terminate
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("It takes " + (end - start) + " milli seconds.");

    }

}

//consumer - multi threads
class CPUTask implements Runnable {

    private final BlockingQueue<String> queue;

    public CPUTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String directoryPath;
        while(true) {
            try {
                // block if the queue is empty
                directoryPath = queue.take();
                File[] files = new File(directoryPath).listFiles();
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsoluteFile());
                    }
                    if (file.isDirectory()){
                        try {
                            //auto block if the queue is full
                            queue.put(file.getAbsolutePath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (InterruptedException ex) {
                break; // FileTask/Producer has completed
            }
        }
        // poll() returns null if the queue is empty
        // process the rest of the queue after Producer job done and interrupt Consumer
        while((directoryPath = queue.poll()) != null) {
            File[] files = new File(directoryPath).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsoluteFile());
                }
                if (file.isDirectory()){
                    try {
                        //auto block if the queue is full
                        queue.put(file.getAbsolutePath());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

//producer - single thread
class FileTask implements Runnable {

    private final BlockingQueue<String> queue;

    public FileTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String sourceDir = "/Users/blueaken/Desktop";
        File[] files = new File(sourceDir).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsoluteFile());
            }
            if (file.isDirectory()){
                try {
                    //auto block if the queue is full
                    queue.put(file.getAbsolutePath());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
