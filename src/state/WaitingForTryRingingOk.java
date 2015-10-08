package state;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WaitingForTryRingingOk extends State {

	private Socket inviteSocket;
	
	public WaitingForTryRingingOk() {
		
	}
	@Override
	public String getStateName() {
		return "WAITING_FOR_TRY_RINGING_OK";
	}
	
	public State receiveInvite() {
		System.out.println("BUSY");
		return this;
	}
	
	public State receiveTROK() {
		System.out.println("ACK");
		PrintWriter output;
		try {
			output = new PrintWriter(inviteSocket.getOutputStream(),true);
			output.println("ACK");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Connected();
	}

}
