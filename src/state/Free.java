package state;

import java.io.PrintWriter;
import java.net.Socket;

public class Free extends State {

	private String host = "127.0.0.1"; 
	private Socket inviteSocket;
	
	@Override
	public String getStateName() {
		return "FREE";
	}
	
	public State receiveInvite() {
		return new WaitingForAck();
	}
	
	public State sendInvite(int port) {
		//Send invite here
		try {
			inviteSocket = new Socket(host, port);
			PrintWriter output = new PrintWriter(inviteSocket.getOutputStream(),true);
			output.println("INVITE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new WaitingForTryRingingOk();
	}
}
