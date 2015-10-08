package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class StablishConnection extends Thread {
	
	private StateHandler  state;
	private Socket clientSocket;
	public StablishConnection(StateHandler state, Socket clientSocket) {
		this.state = state;
		this.clientSocket = clientSocket;
	}
	public void run() {
		boolean done = false;
		try (BufferedReader input = new BufferedReader
				(new InputStreamReader(clientSocket.getInputStream())))
		{
			while(!done) {
				String response = input.readLine();
				if(response != null) {
					switch (response) {
					case "ack":
						//Change State
						state.receiveAck();
						done = true;
						break;
					default:
						break;
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
