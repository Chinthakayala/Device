import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
@WebServlet("/RecordInsertion")
public class RecordInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray DeviceDetailsList = new JSONArray();   
    public RecordInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }
	@SuppressWarnings({ "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		JSONObject DeviceDetails = new JSONObject();
		DeviceDetails.put("xxdeviceId", request.getParameter("xxdeviceId"));
		DeviceDetails.put("emsSessionId", request.getParameter("emsSessionId"));
		DeviceDetails.put("user", request.getParameter("user"));
		DeviceDetails.put("xxOperation", request.getParameter("xxOperation"));
		DeviceDetails.put("xxdeviceType", request.getParameter("xxdeviceType"));
		DeviceDetails.put("xxIpaddress", request.getParameter("xxIpaddress"));
		DeviceDetails.put("emsIp", request.getParameter("emsIp"));
		DeviceDetailsList=getRecords();
		DeviceDetailsList.add(DeviceDetails);
		try (FileWriter file = new FileWriter("C:\\Users\\cprakash\\Desktop\\Displaydevice.json"))
		{
			 
	            file.write(DeviceDetailsList.toJSONString());
			    file.flush();
                System.out.println("sucess");
                response.sendRedirect("Displaydetails.jsp");
              
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
 	private JSONArray getRecords() throws IOException 
		      {	
						JSONParser jsonParser = new JSONParser();
						try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\Displaydevice.json"))
						{	
						        	Object obj = jsonParser.parse(reader);
									JSONArray employeeList = (JSONArray) obj;
									return employeeList;
						} 
						catch(Exception e)
						{    
						}
		           return new JSONArray();
		      }
}
