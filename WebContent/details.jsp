<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Device</title>
	<script type="text/javascript" src="jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="StyleSheet.css">
</head>

<body>
     <h1>Register Device</h1>
	<div class="form">
	     
		<form name="f1" method="GET" id="f1" action="RecordInsertion">
			<table border="1" id="table">
				
				<tr>
					<td colspan="2"><span id="errorMessage"></span></td>
				</tr>
				<tr>
					<th>xxdeviceId</th>
					<td><input type="text" name="xxdeviceId" id="fn1"
						placeholder="" required />
					<label id="lbe1">Duplicate xxdeviceId..!</label>
					</td>
				</tr>
				<tr>
					<th>emsSessionId</th>
					<td><input type="number" id="fn2" name="emsSessionId" required />
					<label id="lbe2">Duplicate emsSessionId..!</label>
					</td>
				</tr>
				<tr>
					<th>user</th>
					<td><input type="text" id="fn3" name="user" required /></td>
				</tr>
				<tr>
					<th>xxOperation</th>
					<td>
					<select name="xxOperation" id="fn4">
							<option value="launchSbxDevice">launchSbxDevice</option>
							<option value="launchPsxDevice">launchPsxDevice</option>
							<option value="launchConfig">launchConfig</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>xxdeviceType</th>
					<td>
					<select name="xxdeviceType" id="fn5">
							<option value="SBX5K">SBX5K</option>
							<option value="SBX7K">SBX7K</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>xxIpaddress</th>
					<td><input type="text" id="fn6" name="xxIpaddress" required /></td>
				</tr>
				<tr>
					<th>emsIp</th>
					<td><input type="text" id="fn7" name="emsIp" required /></td>
				</tr>
			</table>
			<div class="centerBlock">
				<input type="submit" name="submit" onclick="return fun()" value="submit" />
			<a href="http://localhost:8080/Test2/Displaydetails.jsp">	<input type="button" value="Device Details"> </a>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="validation.js"></script>
</body>
</html>