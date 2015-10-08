package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ListenForConnections extends Thread {

	private static int PORT;
	private StateHandler state;
	private ServerSocket listeningSocket;
	private Socket clientSocket;
	private boolean done;
	
	public ListenForConnections(StateHandler state) throws IOException {
		Random rand = new Random();
		PORT = rand.nextInt((49151 - 1024) + 1) + 1024;
		this.state = state;
		listeningSocket = new ServerSocket(PORT);
		clientSocket = null;
		done = false;
		System.out.println("PORT: " + PORT);
	}
	
	public void run() {
		
		int counter = 0;
		while(!done) {
			System.out.println("waiting for Invite...");
			try {
				clientSocket = listeningSocket.accept();
				System.out.println(counter++);
				System.out.println("Client Connected!");
//				StablishConnection connection = new StablishConnection(state, clientSocket);
//				connection.start();
				
				BufferedReader input = new BufferedReader
						(new InputStreamReader(clientSocket.getInputStream()));
				System.out.println(input.readLine());
				
				PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
//				output.write("TRY_RINGING_OK_");
				System.out.print("> ");
				Scanner scanner = new Scanner(System.in);
				String response = scanner.nextLine();
				output.write(response);
				
				state.receiveInvite();
				System.out.println("IN THREAD: " +state.getState());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void close() {
		done = true;
	}
}
