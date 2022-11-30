package soket;
import java.io.*;
import java.net.*;

public class UserReadClientThread extends Thread {
  private BufferedReader reader,in,stdIn;
  private Socket socket;
  private ChatClient client;

  public UserReadClientThread(Socket socket, ChatClient client) {
    this.socket = socket;
    this.client = client;

    try {
      //InputStream input = this.socket.getInputStream();
      //reader = new BufferedReader(new InputStreamReader(input));
    	in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	stdIn=new BufferedReader(new InputStreamReader(System.in));
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
      ex.printStackTrace();
    }
  }

	public void run() {
		String response = "";
		
		try {
			
			while(true) {	
			while ((response = in.readLine()) != null) {
				
				client.mensaje=response;
			}}
			
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
			
		}

	}
}
