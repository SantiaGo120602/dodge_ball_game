package src.controller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient implements AbstractUDPSocket{
    private InetAddress serverAddress;
    private int serverPort;
    private DatagramSocket socket;

    public UDPClient(String serverAddress, int port) throws SocketException, UnknownHostException {
        this.serverAddress = InetAddress.getByName(serverAddress);
        this.serverPort = port;
        this.socket = new DatagramSocket(port);
    }

    @Override
    public void sendData(String sendData) {
        Thread sendThread = new Thread(() -> {
            try {

                    byte[] data = sendData.getBytes();
                    DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
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
