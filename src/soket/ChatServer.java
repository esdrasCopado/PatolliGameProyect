package soket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {

  private static int port;                                           // Puerto para la conexión
  private Set<String> users = new HashSet<>();                // Lista de usuarios
  private Set<UserServerThread> threads = new HashSet<>();    // Hilos de ejecución (uno por usuario)

  public ChatServer (int port) {
    this.port=port;
  }
public static void main(String[]args) {
	ChatServer server=new ChatServer(8002);
	server.start();
}

  public void start() {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Servidor de Chat ejecutandose en el puerto " + port);
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Nuevo usuario conectado.");
        UserServerThread newUser = new UserServerThread(socket, this);
        threads.add(newUser);
        newUser.start();
      }
    } catch (IOException ex) {
      System.out.println("Error al iniciar el Servidor de Chat: " + ex.getMessage());
      ex.printStackTrace();
    }
  }

  /**
   * Delivers a message from one user to others (broadcasting)
   */
  void broadcast(String message, UserServerThread excludeUser) {
    for (UserServerThread userThread : threads) {
      if(userThread!=excludeUser) {
        userThread.sendMessage(message);
      }
    }
  }

  /**
   * Stores username of the newly connected client.
   */
  void addUserName(String userName) {
    users.add(userName);
  }

  /**
   * When a client is disconneted, removes the associated username and UserThread
   */
  void removeUser(String userName, UserServerThread aUser) {
    boolean removed = users.remove(userName);
    if (removed) {
      threads.remove(aUser);
      System.out.println("El usuario " + userName + " salió.");
    }
  }

  Set<String> getUserNames() {
    return this.users;
  }

  /**
   * Returns true if there are other users connected (not count the currently connected user)
   */
  boolean hasUsers() {
    return !this.users.isEmpty();
  }

}