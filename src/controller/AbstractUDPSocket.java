package src.controller;

public interface AbstractUDPSocket {
    public void openConnection();
    public void closeConnection();
    public void sendData(String sendData);
    public String recieveData();
}
