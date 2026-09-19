import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InternshipHandler implements HttpHandler{

@Override 
    public  void handle(HttpExchange exchange) throws IOException{
        String response ="";

        try {
            Connection connection = DatabaseConnection.getConnection();

            Statement statement = connection.createStatement();

            String sql = "Select i.internship_id, "+ "i.title, "+"i.description, "+
                         "i.work_type, "+"i.start_date, "+"end_date, "+"i.application_deadline, "+
                         "i.number_of_position, "+"i.status, "+"c.company_name, "+"l.city, "+"l.country, "+
                         "from internship i "+ " Join company c on i.company_id = c.company_id"+
                         "left join location l on i.location_id = l.location_id";

                         ResultSet result = statement.executeQuery(sql);

                         response += "[";

                         boolean first = true;

                         while (result.next()){
                            if (!first){
                                response +=",";
                            }

                            response += "{";

                            response += "\"internship_id\":" + result.getInt("internship_id")+",";
                            response += "\"title\":\"" + result.getString("title")+"\",";
                            response += "\"description\":\"" + result.getString("description")+"\",";
                            response += "\"work_type\":\"" + result.getString("work_type")+"\",";
                            response += "\"start_date\":\""+result.getString("start_date")+"\",";
                            response += "\"end_date\":\""+ result.getString("end_date")+"\",";
                            response += "\"application_deadline\":\"" + result.getString("application_deadline")+"\",";
                            response += "\"number_of_position\":\"" + result.getByte("number_Of_position")+"\",";
                            response += "\"status\":\"" + result.getString("status")+"\",";
                            response += "\"company_name\":\"" +result.getString("company_name")+"\",";
                            response += "\"city\":\"" +result.getString("city")+"\",";
                            response += "\"country\":\"" + result.getString("country")+"\",";

                            response +="}";
                            first = false;
                         }
                         response += "]";

                         result.close();
                         statement.close();
                         connection.close();
        }catch(Exception e){
            response += "{\"error\":\"DatabaseError\"}";

            e.printStackTrace();
        }  
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream output = exchange.getResponseBody();
        output.write(response.getBytes());
        output.close();
    }


}
