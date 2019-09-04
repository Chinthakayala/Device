import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
@WebServlet("/JsonWriting")
public class JsonWriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JsonWriting()
       {
          super(); 
       }
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\Displaydevice.json"))
		{
			
		        	Object obj = jsonParser.parse(reader);
					JSONArray deviceDetailsList= (JSONArray) obj;
					int k=deviceDetailsList.size();
					response.setContentType("application/json");
			        response.getWriter().print(deviceDetailsList);
 
		} 
		catch(Exception e)
		{
	         
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
