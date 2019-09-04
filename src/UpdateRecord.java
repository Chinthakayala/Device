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
@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public UpdateRecord() {
		        super();
		        
		    }
    
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
      String id=request.getParameter("xxdeviceId"); 
	  JSONParser jsonParser = new JSONParser(); 
	  JSONArray deviceList1= new JSONArray();
		  try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\Displaydevice.json"))
		  {
			    
			  Object obj = jsonParser.parse(reader);
			  JSONArray deviceList = (JSONArray)obj;
			  Iterator itr=deviceList.iterator();
			  
					  for(int i=1;i<=deviceList.size();i++)
					  {
					     JSONObject returnObject = (JSONObject)itr.next();
					     System.out.println(returnObject.get("xxdeviceId"));
					     System.out.println(id.equals(returnObject.get("xxdeviceId")));
					        
							  if(id.equals(returnObject.get("xxdeviceId")))  
							  {
								  System.out.println("if block"); 
								  JSONObject obj1=new JSONObject();
								  obj1.put("xxdeviceId",request.getParameter("xxdeviceId"));
								  obj1.put("emsSessionId",request.getParameter("emsSessionId"));
								  obj1.put("user",request.getParameter("user"));
								  obj1.put("xxOperation",request.getParameter("xxOperation"));
								  obj1.put("xxdeviceType",request.getParameter("xxdeviceType"));
								  obj1.put("xxIpaddress",request.getParameter("xxIpaddress"));
								  obj1.put("emsIp",request.getParameter("emsIp"));
								  deviceList1.add(obj1);
							  }
							  else 
							  { 
								  System.out.println("else block"); 
								  deviceList1.add(returnObject); 
							  } 
						}
					  System.out.println(deviceList1.toJSONString());
			  }
	      catch(Exception e)
		  { 
		     e.printStackTrace(); 
		  }
	  
			  try (FileWriter file = new FileWriter("C:\\Users\\cprakash\\Desktop\\Displaydevice.json")) {
			  file.write(deviceList1.toJSONString());
			  System.out.println(deviceList1.toJSONString()); 
			  
			//file.flush();
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
