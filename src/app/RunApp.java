package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunApp {

	public static void main(String[] args) throws IOException {
		
		boolean done = false;
		try(BufferedReader scanner = new BufferedReader
				(new InputStreamReader(System.in))){
			
			StateHandler stateHandler = new StateHandler();
			ListenForConnections listener = new ListenForConnections(stateHandler);
			listener.start();
			//Write loop
			while(!done) {
				//FREE STATE
				if(stateHandler.getState().equals("FREE")) {
					System.out.println(stateHandler.getState());
				}
				System.out.print(">");
				while(stateHandler.getState().equals("FREE")) {
					//System.out.println(stateHandler.getState());
					if(scanner.ready()) {//A
						String input = scanner.readLine();
						String[] port = null;
						if(input.contains("invite_")) {
							port = input.split("_");
							stateHandler.sendInvite(Integer.parseInt(port[1]));
						}else {
							switch (input) {
							case "quit":
								//Close all the threads
								done = true;
								break;
							default:
								break;
							}
						}
					}
				}
				//WAITING_FOR_ACK
				while(stateHandler.getState().equals("WAITING_FOR_ACK")) {
					System.out.println(stateHandler.getState());
					
				}
				//WAITING_FOR_TRY_RINGING_OK
				while(stateHandler.getState().equals("WAITING_FOR_TRY_RINGING_OK")) {
					System.out.println(stateHandler.getState());
					
				}
				//WAITING_FOR_OK
				while(stateHandler.getState().equals("WAITING_FOR_OK")) {
					System.out.println(stateHandler.getState());
					
				}
				//CONNECTED
				while(stateHandler.getState().equals("CONNECTED")) {
					System.out.println(stateHandler.getState());
					
				}
			}
		}
		
		System.out.println("Main BYE!");
	}

}
