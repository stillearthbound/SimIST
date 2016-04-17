
import java.net.*;
import java.io.*;
import java.util.*;
import sandbox.ChatMessage;
import sandbox.ServerNetworking;


public class ClientNetworking  {

	private ObjectInputStream sInput;		
	private ObjectOutputStream sOutput;		
	private Socket socket;

	
         private ServerNetworking cg;


	private String server;
	private int port;

	
	ClientNetworking(String server, int port) {
		// which calls the common constructor with the GUI set to null
		this.server =server;
                this.port = port;
	}


	ClientNetworking(String server, int port, String username) {
		this.server = server;
		this.port = port;
		
		
        }	
	
        
	public boolean start() {
		try {
			socket = new Socket(server, port);
		} 
		catch(Exception ec) {
                    System.out.println("Error connectiong to server:" + ec);
		return false;
		}
		
		String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
		 System.out.println(msg);
	
		try
		{
			sInput  = new ObjectInputStream(socket.getInputStream());
			sOutput = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO) {
			 System.out.println("Exception creating new Input/output Streams: " + eIO);
			return false;
		}

		new ListenFromServer().start();
		
		return true;
	}

	
	
	/*
	 * To send a message to the server
	 */
	void sendMessage(ChatMessage msg) {
		try {
			sOutput.writeObject(msg);
		}
		catch(IOException e) {
			System.out.println("Exception writing to server: " + e);
		}
	}


	
	public static void main(String[] args) {
		
	int portNumber = 1500;
	String serverAddress = "localhost";
	String userName = "Anonymous";

		switch(args.length) {
			case 3:
				serverAddress = args[2];
			// > javac Client username portNumber
			case 2:
                	try {
					portNumber = Integer.parseInt(args[1]);
				}
                        catch(Exception e) {
			System.out.println("Invalid port number.");
			System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
					return;
				}
			
			case 0:
				break;
			// invalid number of arguments
			default:
				System.out.println("Usage is: > java Client [portNumber] {serverAddress]");
			return;
		}
                
		// Client Object
		ClientNetworking client = new ClientNetworking(serverAddress, portNumber, userName);

                if(!client.start())
			return;
		
		Scanner scan = new Scanner(System.in);
		// loop forever for message from the user
		
	}


	class ListenFromServer extends Thread {

		public void run() {
			while(true) {
				try {
					String msg = (String) sInput.readObject();
			if(cg == null) {
						System.out.println(msg);
						System.out.print("> ");
					}
					
				}
				catch(IOException e) {
					System.out.println("Server has close the connection: " + e);
					
				}
				catch(ClassNotFoundException e2) {
				}
			}
		}
	}
}


