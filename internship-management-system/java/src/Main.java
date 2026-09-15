import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Main{

	public static void main (String [] args) throws IOException{

	HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

	server.createContext("/", exchange -> { String response = "Internshio Management system backend is running";
	exchange.sendResponseHeaders(200, response.length());
	exchange.getResponseBody().write(response.getBytes());
	exchange.getResponseBody().close(); });

	server.createContext("\companies", new CompanyHandler());

	server.start();
	System.out.println("Server stsrt at http://localhost:8080");

	}

}
