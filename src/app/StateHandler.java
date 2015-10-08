package app;

import state.Free;
import state.State;

public class StateHandler {
	
	private State currentState;
	
	public StateHandler() {
		this.currentState = new Free();
	}
	
	public String getState() {
		return this.currentState.getStateName();
	}
	
	public void receiveInvite() {
		currentState = currentState.receiveInvite();
	}
	public void receiveBye() {
		currentState = currentState.receiveBye();
	}
	
	public void receiveOk() {
		currentState = currentState.receiveOk();
	}
	
	public void receiveTROK() {
		currentState = currentState.receiveTROK();
	}
	
	public void receiveAck() {
		currentState = currentState.receiveAck();
	}
	
	public void sendBye() {
		currentState = currentState.sendBye();
	}
	
	public void sendInvite(int port) {
		currentState = currentState.sendInvite(port);
	}
}
