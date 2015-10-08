package state;

public class WaitingForOk extends State {

	@Override
	public String getStateName() {
		return "WAITING_FOR_OK";
	}
	
	public State receiveInvite() {
		System.out.println("BUSY");
		return this;
	}
	
	public State receiveOk() {
		return new Free();
	}
}
