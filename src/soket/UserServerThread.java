package soket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class UserServerThread extends Thread {
  private Socket socket;
  private ChatServer server;
  private PrintWriter writer;

  public UserServerThread(Socket socket, ChatServer server) {
    this.socket = socket;
    this.server = server;
  }

  public void run() {
    try {
      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      OutputStream output = socket.getOutputStream();
      writer = new PrintWriter(output, true);



      String clientMessage;

      do {
        clientMessage = reader.readLine();
        System.out.println(clientMessage);
        server.broadcast(clientMessage, this);
      } while (!clientMessage.equals("bye"));

      
      socket.close();


    } catch (IOException ex) {
      System.out.println("Error in UserThread: " + ex.getMessage());
      ex.printStackTrace();
    }
  }

  /**
   * Sends a list of online users to the newly connected user.
   */
  void printUsers() {
    if (server.hasUsers()) {
      writer.println("Lista de usuarios conectados: " + server.getUserNames());
    } else {
      writer.println("No hay usuarios conectados.");
    }
  }

  /**
   * Sends a message to the client.
   */
  void sendMessage(String message) {
	  
    writer.println(message);
  }

}