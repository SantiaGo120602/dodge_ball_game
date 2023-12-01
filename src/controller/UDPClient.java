package src.controller;

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
    public void openConnection() {
        throw new UnsupportedOperationException("Unimplemented method 'openConnection'");
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Unimplemented method 'closeConnection'");
    }

    @Override
    public void sendData(String sendData) {
        throw new UnsupportedOperationException("Unimplemented method 'sendData'");
    }

    @Override
    public String recieveData() {
        throw new UnsupportedOperationException("Unimplemented method 'recieveData'");
    }    
}
