package realworld.sap.devops.linuxjs;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: blueaken
 * Date: 7/4/16 11:25
 */
public class Solution_MultiThread {

    // BlockingQueue with a capacity of 200
    private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    //private static Integer globalCounter = 0;
    private static AtomicInteger counter = new AtomicInteger(1); // a global counter
    //SJ: 2016/12/26
    //try to add a counter for the number of files and directories printed but to add it in the main() function seems
    // not working. The solution should be use ThreadLocal counter in each thread, then sum up them together. Spend too
    // much time on this today and does not code.


    public static void main(String[] args) {
//        String test = "/Users/blueaken/Desktop";
        String test = "/Users/jianshen/Desktop";

        Solution solution = new Solution();
        solution.listFilesAndFolders(test);

        long start = System.currentTimeMillis();

        final int threadCount = 10;

        // create thread pool with given size
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        // start CPUTask/Consumer multi threads first, so as to start working as soon as there is new
        // entry in the blocking queue
        for (int i = 0; i < threadCount; i++) {
            service.submit(new CPUTask());
        }

        // start FileTask/Producer thread next
        FileTask fileTask = new FileTask();
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
        System.out.println("Total item processed: " + counter.toString());

    }


    //consumer - multi threads
    static class CPUTask implements Runnable {

        //private final BlockingQueue<String> queue;

//        public CPUTask(BlockingQueue<String> queue) {
//            this.queue = queue;
//        }


        public CPUTask() {
        }

        @Override
        public void run() {
            String directoryPath;
            while (true) {
                try {
                    // block if the queue is empty
                    directoryPath = queue.take();
                    File[] files = new File(directoryPath).listFiles();
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getAbsoluteFile());
//                            globalCounter++;
                            counter.getAndIncrement();
                        }
                        if (file.isDirectory()) {
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
//        while((directoryPath = queue.poll()) != null) {
//            File[] files = new File(directoryPath).listFiles();
//            for (File file : files) {
//                if (file.isFile()) {
//                    System.out.println("File: " + file.getAbsoluteFile());
//                }
//                if (file.isDirectory()){
//                    try {
//                        //auto block if the queue is full
//                        queue.put(file.getAbsolutePath());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
        }
    }

    //producer - single thread
    static class FileTask implements Runnable {

//        private final BlockingQueue<String> queue;
//
//        public FileTask(BlockingQueue<String> queue, int global_counter) {
//            this.queue = queue;
//        }


        public FileTask() {
        }

        @Override
        public void run() {
            String sourceDir = "/Users/blueaken/Desktop";
            File[] files = new File(sourceDir).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsoluteFile());
//                    globalCounter++;
                    counter.getAndIncrement();
                }
                if (file.isDirectory()) {
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