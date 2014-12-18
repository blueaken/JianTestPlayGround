import java.util.Random;

/**
 * @author jianshen
 */
public class BCZM1_10 {
    static class GlobalBuffer {
        // Display a message, preceded by the name of the current thread
        static void threadMessage(String message) {
            String threadName =
                    Thread.currentThread().getName();
            System.out.format("%s: %s%n",
                    threadName,
                    message);
        }

        private int INITIAL_BUFFER_SIZE = 10;
        private Integer[] buffer = new Integer[INITIAL_BUFFER_SIZE];
        private int index = 0;

        public synchronized void getBlockFromNet(int input){
            while (index == buffer.length-1){
                try{
                    wait();
                }catch (InterruptedException ie){
                    threadMessage("I am not done!");
                }
            }

            buffer[index++] = input;
            notifyAll();
            return;

        }

        public synchronized int writeBlockToDisk(){
            int currentBlock;
            while (index == 0){
                try{
                    wait();
                }catch (InterruptedException ie){
                    threadMessage("I am not done!");
                }
            }

            currentBlock = buffer[--index];
            notifyAll();
            return currentBlock;
        }
    }

    // Display a message, preceded by the name of the current thread
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    public static void main (String[] args){
        GlobalBuffer globalBuffer = new GlobalBuffer();

        Thread downloadTask = new Thread(new DownloadTask(globalBuffer), "Download Thread");
        Thread writeToDiskTask = new Thread(new WriteToDiskTask(globalBuffer), "Write disk Thread");

        downloadTask.start();
        writeToDiskTask.start();
    }

    static class DownloadTask implements Runnable {
        private GlobalBuffer globalBuffer = new GlobalBuffer();

        DownloadTask(GlobalBuffer globalBuffer){
            this.globalBuffer = globalBuffer;
        }

        @Override
        public  void run(){
            while (true){
                threadMessage("DownloadTask is running @ " + System.currentTimeMillis());
                Random random = new Random();
                globalBuffer.getBlockFromNet(random.nextInt());
            }
        }
    }

    static class WriteToDiskTask implements Runnable {
        private GlobalBuffer globalBuffer = new GlobalBuffer();

        WriteToDiskTask(GlobalBuffer globalBuffer){
            this.globalBuffer = globalBuffer;
        }

        private int currentBlock;
        @Override
        public  void run(){
            while (true){
                threadMessage("WriteToDiskTask is running @ " + System.currentTimeMillis());
                currentBlock = globalBuffer.writeBlockToDisk();
            }
        }
    }

}


