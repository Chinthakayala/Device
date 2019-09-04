import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
@WebServlet("/Reload")
public class Reload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Reload() {
        super();
       
    }
	@SuppressWarnings({ "unused", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=(String)request.getParameter("ID");
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\Displaydevice.json"))
		{
			       JSONObject ReturnObject = null;
		        	Object obj = jsonParser.parse(reader);
					JSONArray deviceList = (JSONArray) obj;
					Iterator itr=deviceList.iterator();
					System.out.println(deviceList.size());
					for(int i=0;i<deviceList.size();i++)
					{
						ReturnObject=(JSONObject)itr.next();
						if(id.equals(ReturnObject.get("xxdeviceId")))
						{
							break;
						}
					}
					response.setContentType("application/json");
			        response.getWriter().print(ReturnObject);
 
		} 
		catch(Exception e)
		{
	         
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
