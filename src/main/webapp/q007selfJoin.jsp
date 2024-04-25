<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.*" %>


<%
	//EmpDAO.selectSeltJoin메소드
	ArrayList<HashMap<String, Object>> list
		= EmpDAO.selectSelfJoin();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mgrGrade 별 출력하기</title>
</head>
<body>
	<table border="1">
				<tr>
					<th>EMPNO</th>
					<th>ENAME</th>
					<th>GRADE</th>
					<th>MGRName</th>
					<th>mgrGRADE</th>
				</tr>
			<%
				for(HashMap<String, Object> m : list) {
			%>
				<tr>
					<td><%=m.get("empNo")%></td>
					
					<td><%=m.get("ename")%></td>
					
					<td>
						<%
							for(int i=0; i<(Integer)(m.get("grade")); i=i+1) {
						%>
								&#128151;
						<%
							}
						%>
					</td>
					
					<td><%=m.get("mgrName")%></td>
					<td>
						<%
							for(int i=0; i<(Integer)(m.get("mgrGrade")); i=i+1) {
						%>
								&#128151;
						<%
							}
						%>
					</td>
				</tr>
			<%
				}
			%>
	</table>
</body>
</html>