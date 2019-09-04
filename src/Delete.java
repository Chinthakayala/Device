import java.io.FileReader;
import java.io.FileWriter;
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
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Delete() {
        super();
    }
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 JSONParser jsonParser = new JSONParser();
		 JSONArray deviceList_new=new JSONArray();
		 String id=request.getParameter("ID");
		try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\Displaydevice.json"))
		  {
			  Object obj = jsonParser.parse(reader);
			  JSONArray deviceList = (JSONArray)obj;
			  Iterator itr=deviceList.iterator();
			  for(int i=1;i<=deviceList.size();i++)
			  {
				  JSONObject obj1=(JSONObject)itr.next();
		          if(id.equals(obj1.get("xxdeviceId"))) 
		          {
		        	  
		          }
		          else
		          {
		        	  deviceList_new.add(obj1) ;
		          }	  
			  }
			  
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 try (FileWriter file = new FileWriter("C:\\Users\\cprakash\\Desktop\\Displaydevice.json")) {
			  file.write(deviceList_new.toJSONString());
			  System.out.println(deviceList_new.toJSONString()); 
			  response.sendRedirect("Displaydetails.jsp"); 
			  } 
			  catch (Exception e) {
			  e.printStackTrace();
			  }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
