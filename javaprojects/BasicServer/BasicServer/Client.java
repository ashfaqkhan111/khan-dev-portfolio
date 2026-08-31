import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (
            Socket socket = new Socket(host, port);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            PrintWriter output = new PrintWriter (socket.getOutputStream(), true);
            Scanner in = new Scanner(System.in);
        ){
            System.out.println("Connected to server ");
            while (true) {
                System.out.println("You : ");
                String message = in.nextLine();

                output.println(message);

                String response = input.readLine();
                System.out.println(response);

                if(message.equalsIgnoreCase("bye"));
                break;
                
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
