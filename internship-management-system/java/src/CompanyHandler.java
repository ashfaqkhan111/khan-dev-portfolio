import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompanyHandler implements HttpHandler {

	@Override
	public void handle (HttpExchange exchange) throws IOException {

	String response = "";

	try{

	Connection connection = DatabaseConnection.getConnection();

	Statement statement = connection.createStatement();

	ResultSet result = statement.executeQuery("SELECT company_id, company_name, industry, email FROM company");

	response += "[";
	boolean first = true;

	while (result.next()){
	
		if(!first){
			response += ",";
			}

		response += "{";
		response += "\"company_id\":" + result.getInt("company_id") + ",";
		response += "\"company_name\":\"" + result.getString("company_name")+"\",";
		response += "\"industry\":\""+ result.getString("industry")+"\",";
		response += "\"email\":\""+ result.getString("email")+"\"";
		response += "}";
		first=false;

		

	}
		response +="]";

		result.close();
		statement.close();
		connection.close();

		}catch(Exception e){
			response = "{\"error\":\"Database error\"}";
			e.printStackTrace();

		}

		exchange.sendResponseHeaders(200, response.getBytes().length);

		OutputStream output = exchange.getResponseBody();
		output.write(response.getBytes());
		output.close();

	}

}
