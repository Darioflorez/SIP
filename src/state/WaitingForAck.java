package state;

public class WaitingForAck extends State {

	@Override
	public String getStateName() {
		return "WAITING_FOR_ACK";
	}
	
	public State receiveAck() {
		return new Connected();
	}
	
	public State receiveInvite() {
		System.out.println("BUSY");
		return this;
	}
}
