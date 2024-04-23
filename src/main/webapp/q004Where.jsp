<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.*"%>
<%@ page import="dao.*"%>
<%
	ArrayList<Emp> list =null;
	String[] ck =request.getParameterValues("ck");
	if(ck==null){
	System.out.println(ck +"<--ck");
	}else{
		System.out.println(ck.length + "<-- ck.length");
		ArrayList<Integer>ckList = new ArrayList<>();
		for(String s: ck){
			ckList.add(Integer.parseInt(s));
		}
		
		list = EmpDAO.selectEmpListByGrade(ckList);
		System.out.println(list.size()+"<-결과행(list.size())");
	}
%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title></title>
</head>
<body>
   <h1>EMP GRADE 검색</h1>
   <form action="./q004Where.jsp" method="post">
      GRADE : 
      <%
         for(int i=1; i<6; i=i+1) {
      %>
            <input type="checkbox" name="ck" value="<%=i%>"><%=i%>
      <%      
         }
      %>
      <br>
      <button type="submit">검색</button>
   </form>
   
   <%
   if(ck==null){    //(list =null)
   return; //check가  안되어있다면 아무것도 출력하지않는다  체크박스 1->1출력 2 ->2 ..
   }
   %>
   <table border="1">
   		<tr>
   			<th>ename</th>
   			<th>grade</th>
   		</tr>
   		<%
   			for(Emp e: list){
   		%>
   		<tr>
   			<td><%=e.getEname()%></td>
  			<td><%=e.getGrade()%></td>
   		</tr>
   		<%
   			}
   		%>
   </table>
</body>
</html>