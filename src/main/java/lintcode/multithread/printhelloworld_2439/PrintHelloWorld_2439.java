package lintcode.multithread.printhelloworld_2439;

import java.util.concurrent.Semaphore;

public class PrintHelloWorld_2439 {
    // write your code here
    Semaphore sHello = new Semaphore(1);
    Semaphore sWorld = new Semaphore(0);

    public void printHello() throws InterruptedException {
        // write your code here
        sHello.acquire();
        System.out.print("Hello");
        sWorld.release();
    }

    public void printWorld() throws InterruptedException {
        // write your code here
        sWorld.acquire();
        System.out.print("World");
        sHello.release();
    }
}
