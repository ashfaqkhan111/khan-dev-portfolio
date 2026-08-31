import java.io.*;
import java.net.*;

public class Server {

public static void main(String [] args) {

	int port = 5000;

	try (ServerSocket serverSocket =  new ServerSocket (port)) {

		System.out.println("Server started.");
		System.out.println("Waiting for claints....");
		
		Socket socket = serverSocket.accept();

        System.out.println("Clint Connected: "+ socket.getInetAddress());

        BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        String meassage;

        while ((meassage = input.readLine()) != null){
            System.out.println("Client : "+meassage);
            output.println("Server received : " + meassage);
            
            if (meassage.equalsIgnoreCase("bye")){
                break;
            }
        }

        socket.close();
        System.out.println("Client disconnected.");

		}catch (IOException e){
        e.printStackTrace();
        }

	


    }

}
