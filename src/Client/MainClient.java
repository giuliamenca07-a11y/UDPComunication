package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT");

        try {
            InetAddress serverAddress = InetAddress.getLocalHost();
            System.out.println("Indirizzo del server trovato");
            while(true) {
                DatagramSocket dSocket = new DatagramSocket();
                System.out.println("Scrivere un messaggio da mandare al server: ");
                Scanner sc = new Scanner(System.in);
                String message = sc.nextLine();
                DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, 3000);
                dSocket.send(outPacket);
                byte[] bufferIn = new byte[256];
                DatagramPacket inputPacket = new DatagramPacket(bufferIn, bufferIn.length);
                dSocket.receive(inputPacket);
                String Servermessage = new String(inputPacket.getData(), 0, inputPacket.getLength());
                System.out.println("Server: " + Servermessage);
            }
        } catch (IOException e) {
            System.out.println("Errore");
        } finally {
        //dSocket.close();
    }

    }
}