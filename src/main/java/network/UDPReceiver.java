package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by jshe18 on 11/4/15.
 */
public class UDPReceiver {

    public static void main(String[] args) {
        int port = args.length == 0 ? 57 : Integer.parseInt(args[0]);
        new UDPReceiver().run(port);
    }

    public void run(int port) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(port);
            byte[] receiveData = new byte[8];

            System.out.printf("Listening on udp:%s:%d%n",
                    InetAddress.getLocalHost().getHostAddress(), port);
            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            while(true)
            {
                serverSocket.receive(receivePacket);
                String sentence = new String( receivePacket.getData(), 0,
                        receivePacket.getLength() );
                System.out.println("RECEIVED: " + sentence);
                // now send acknowledgement packet back to sender
                InetAddress IPAddress = receivePacket.getAddress();
                String sendString = "polo";
                byte[] sendData = sendString.getBytes("UTF-8");
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        IPAddress, receivePacket.getPort());
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        // should close serverSocket in finally block
    }
}
