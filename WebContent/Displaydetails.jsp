<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.simple.parser.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Device Details</title>
<link rel="stylesheet" type="text/css" href="displayDetails.css">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>
        <h1>  Device Details   </h1>
       <div id="table">
			   <table>
			            <tr>
			                 <th>xxdeviceId</th><th>emsSessionId</th>
			                 <th>user</th><th>xxOperation</th>
			                 <th>xxdeviceType</th><th>xxIpaddress</th>
			                 <th>emsIp</th>
			                 <th>action</th>
			            </tr>
			            <%
			                System.out.println("bhanu");
				            JSONParser jsonParser = new JSONParser();
				            File numbersOfObjects = new File("C:\\Users\\cprakash\\Desktop\\Displaydevice.json");
				            System.out.println(numbersOfObjects.length());
				            System.out.println("bhanu");
				            
					            if(numbersOfObjects.length()==0) {
					    			
					    		}
				    		else
				              {
				    				try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\Displaydevice.json"))
				    				{
				    				    Object obj = jsonParser.parse(reader);
				    					JSONArray deviceList = (JSONArray) obj;
				    					System.out.println(deviceList.toJSONString());
				    					System.out.println(deviceList.size());
				    					Iterator m=deviceList.iterator();
				    					for(int i=0;i<deviceList.size();i++)
				    					{
				    			            JSONObject deviceObject=(JSONObject) m.next() ;
				    						System.out.println(deviceObject.get("xxdeviceId"));
				    						String xxdeviceID=(String)deviceObject.get("xxdeviceId");
				    						String s=(String)deviceObject.get("emsIp");
				    						s="http://"+s;
				    						s=s+":8080/unityexp/launch?emsSessionId=";
				    						s=s+(String)deviceObject.get("emsSessionId");
				    						s=s+"&user=";
				    						s=s+(String)deviceObject.get("user");
				    						s=s+"&xxoperation=";
				    						s=s+(String)deviceObject.get("xxOperation");
				    						s=s+"&xxdeviceType=";
				    						s=s+(String)deviceObject.get("xxdeviceType");
				    						s=s+"&xxIPaddress1=";
				    						s=s+(String)deviceObject.get("xxIpaddress");   
				    						s=s+"&xxdeviceId=";
				    						s=s+(String)deviceObject.get("xxdeviceId");
				    						xxdeviceID="http://localhost:8080/Test2/Reload.html?xxdeviceId="+xxdeviceID;
				    						   
			    		%>				        
			    						    <tr>
			    						       <td><a href=<%=s %> target="_blank"><%= deviceObject.get("xxdeviceId")%></a></td>  <td><%= deviceObject.get("emsSessionId")%></td>
			    						         <td><%= deviceObject.get("user") %></td>          <td><%= deviceObject.get("xxOperation")%></td>
			    						         <td><%= deviceObject.get("xxdeviceType") %></td>  <td><%= deviceObject.get("xxIpaddress")%></td>
			    						         <td><%= deviceObject.get("emsIp") %></td> 
			    						         <td>
			    						             <a class="fa fa-edit anchorDecoration" href=<%=xxdeviceID %> target="_blank"> </a>
			    						             <button title="Delete Device" class="fa fa-times delIcon anchorDecoration" onclick="tableDeleteRow(<%=deviceObject.get("xxdeviceId")%>)"> </button>
			    						         </td>
			    						    </tr>				    
			            <%
			            
			    						  }
			    				}	
				    				catch(Exception e)
				    				{
				    					e.printStackTrace();
				    				}
			    		}			
			            
			            %> 
			   
			   </table>
			    <div id="Register_Device">  <a class="anchorDecoration" href="http://localhost:8080/Test2/details.jsp"> <button title="Register Device"><i class="fa fa-plus"></i> Register Device</button> </a></div>
		</div>	 
		<script type="text/javascript" src="jquery.min.js"></script>
		<script type="text/javascript" src="displayDetails.js"></script>  
</body>
</html>