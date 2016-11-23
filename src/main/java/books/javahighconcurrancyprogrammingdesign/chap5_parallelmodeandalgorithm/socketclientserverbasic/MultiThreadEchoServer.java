package books.javahighconcurrancyprogrammingdesign.chap5_parallelmodeandalgorithm.socketclientserverbasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: blueaken
 * Date: 5/25/16 12:01
 */
public class MultiThreadEchoServer {
    private static ExecutorService tp = Executors.newCachedThreadPool();
    public static class HandleMsg implements Runnable {
        Socket clientSocket;
        public HandleMsg(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(), true);

                //get client data from InputStream
                String inputLine = null;
                long begin = System.currentTimeMillis();
                while ((inputLine = is.readLine()) != null) {
                    os.println(inputLine);
                }
                long end = System.currentTimeMillis();
                System.out.println("spend: " + (end - begin) + "ms");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        try {
            echoServer = new ServerSocket(8000);
        } catch (IOException e) {
            System.out.println(e);
        }

        while (true) {
            try {
                clientSocket = echoServer.accept();
                System.out.println(clientSocket.getRemoteSocketAddress() + " connect!");
                tp.execute(new HandleMsg(clientSocket));
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }
}
