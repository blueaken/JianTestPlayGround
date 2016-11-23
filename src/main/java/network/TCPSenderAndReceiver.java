package network;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jshe18 on 11/4/15.
 */
public class TCPSenderAndReceiver {
    public static void main(String[] args) {
        final String largeFile = "/home/dr/test.dat"; // REPLACE
        final int BUFFER_SIZE = 65536;
        new Thread(new Runnable() {
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(12345);
                    Socket clientSocket = serverSocket.accept();
                    long startTime = System.currentTimeMillis();
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int read;
                    int totalRead = 0;
                    InputStream clientInputStream = clientSocket.getInputStream();
                    while ((read = clientInputStream.read(buffer)) != -1) {
                        totalRead += read;
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println(totalRead + " bytes read in " + (endTime - startTime) + " ms.");
                } catch (IOException e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    Socket socket = new Socket("localhost", 12345);
                    FileInputStream fileInputStream = new FileInputStream(largeFile);
                    OutputStream socketOutputStream = socket.getOutputStream();
                    long startTime = System.currentTimeMillis();
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int read;
                    int readTotal = 0;
                    while ((read = fileInputStream.read(buffer)) != -1) {
                        socketOutputStream.write(buffer, 0, read);
                        readTotal += read;
                    }
                    socketOutputStream.close();
                    fileInputStream.close();
                    socket.close();
                    long endTime = System.currentTimeMillis();
                    System.out.println(readTotal + " bytes written in " + (endTime - startTime) + " ms.");
                } catch (Exception e) {
                }
            }
        }).start();
    }
}
