package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainServer {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(3000);
            System.out.println("Apertura porta in corso");
            byte[] bufferIn = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(bufferIn, bufferIn.lenght);
            datagramSocket.receive(inPacket);
            InetAddres clientAddres = inPacket.getAddress();
            int clientPort = inPacket.getPort();
            messageIn = new String(inPacket.getData(), 0, inPacket.getLenght());
            System.out.println("Sono il Client" + clientAddres + clientPort + messageIn);
        } catch (IOException e) {
        }
    }
}