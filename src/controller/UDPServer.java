package src.controller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer implements AbstractUDPSocket{
    private int clientPort;
    private InetAddress clientAddres;
    private DatagramSocket socket;

    public UDPServer(String serverAddress,int port)  throws SocketException, UnknownHostException {
        this.clientAddres = InetAddress.getByName(serverAddress);
        this.clientPort = port;
        this.socket = new DatagramSocket(port);
    }

    @Override
    public void sendData(String sendData) {
        Thread sendThread = new Thread(() -> {
            try {

                    byte[] data = sendData.getBytes();
                    DatagramPacket packet = new DatagramPacket(data, data.length, clientAddres, clientPort);
                    socket.send(packet);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        sendThread.start();
    }

    @Override
    public String recieveData() {
        byte[] receiveBuffer = new byte[1024]; // Adjust the buffer size as needed
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

        try {
            socket.receive(receivePacket);
            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());

            return receivedData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
}
