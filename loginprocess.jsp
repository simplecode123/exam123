<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<html>
<body>
<%
String n=request.getParameter("u");
String p=request.getParameter("p");
try{
String url="jdbc:mysql://localhost/mydb";
Connection conn=null;
Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection(url,"anand","password");
if(!conn.isClosed())
out.print("succesfully connected to sql");
Statement stm=conn.createStatement();
String sql="SELECT * FROM user WHERE name=\""+n+"\" and pass=\""+p+"\"";
ResultSet rs=stm.executeQuery(sql);
if(rs.next())
out.print("welcome "+n);
else
out.print("sorry username invalid");
rs.close();
stm.close();
conn.close();
}
catch(Exception e)
{
out.print("unable to connect");
}
%>
</body>
</html>
