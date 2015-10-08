package state;

public abstract class State {
	
	public abstract String getStateName();
	
	//Define all the actions that can lead to another state
	public State receiveInvite() {
		return this;
	}
	
	public State receiveBye() {
		return this;
	}
	
	public State receiveOk() {
		return this;
	}
	
	public State receiveTROK() {
		return this;
	}
	
	public State receiveAck() {
		return this;
	}
	
	public State sendBye() {
		return this;
	}
	
	public State sendInvite(int port) {
		return this;
	}
}
