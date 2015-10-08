package state;

public class Connected extends State {

	@Override
	public String getStateName() {
		return "CONNECTED";
	}
	
	public State receiveInvite() {
		System.out.println("BUSY");
		return this;
	}
	
	public State receiveBye() {
		System.out.println("OK");
		return new Free();
	}
	
	public State sendBye() {
		return new WaitingForOk();
	}
}
