<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="java.util.*" %>

<%
ArrayList<HashMap<String, String>> list 
= EmpDAO.selectJobCaseList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>q003case</h1>
	<table border="1">
		<tr>
			<th>ename</th>
			<th>job</th>
		</tr>
		<%
			for(HashMap<String, String> m: list) {
		%>
				<tr>
					<td><%=(String)(m.get("ename"))%></td>
					<td><%=(String)(m.get("job"))%></td>
				</tr>
		<%		
			}
		%>
	</table>
</body>
</html>