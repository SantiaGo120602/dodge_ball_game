package src.controller;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer implements AbstractUDPSocket{
    private int port;
    private DatagramSocket socket;

    public UDPServer(int port) throws SocketException {
        this.port = port;
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
