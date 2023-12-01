package src.controller;

public interface AbstractUDPSocket {
    public void sendData(String sendData);
    public String recieveData();
}
