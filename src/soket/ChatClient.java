package soket;

import java.net.*;

import java.io.*;
import java.io.PrintWriter;

public class ChatClient {
  private String hostname;
  private int port;
  private String userName;
  private PrintWriter writer;
  private Socket socket;
  public static String mensaje;
  public ChatClient(String hostname, int port) {
    this.hostname = hostname;
    this.port = port;
  }


  public void execute() {
    try {
    	socket = new Socket(hostname, port);
    	System.out.println("Conectado al Servidor de Chat.");
    	
    	new UserReadClientThread(socket, this).start();
      //new UserWriteClientThread(socket, this).start();
    	//OutputStream output = socket.getOutputStream();
		//writer = new PrintWriter(output, true);
    } catch (UnknownHostException ex) {
      System.out.println("No se encontró el servidor: " + ex.getMessage());
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }

  public void escribir(String msg) {

		try {
			OutputStream output = socket.getOutputStream();
			writer = new PrintWriter(output, true);
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}

		writer.println(msg);

	}
  void setUserName(String userName) {
    this.userName = userName;
  }

  String getUserName() {
    return this.userName;
  }
  public static void main(String[]args) {
	  ChatClient client=new ChatClient("localhost", 8002);
	  client.execute();
	  
	  
  }
}