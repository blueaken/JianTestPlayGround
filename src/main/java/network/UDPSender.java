package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by jshe18 on 11/4/15.
 */
public class UDPSender {

    public static void main(String[] args) throws IOException {
        byte[] buffer = {10,23,12,31,43,32,24};
        InetAddress address = InetAddress.getByName("192.168.1.106");
        DatagramPacket packet = new DatagramPacket(
                buffer, buffer.length, address, 57
        );
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(packet);
        System.out.println(InetAddress.getLocalHost().getHostAddress());


    }
}
