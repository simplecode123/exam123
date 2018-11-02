import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Scanner;
import java.io.PrintWriter;  
import java.util.Enumeration;  
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.sql.*;
public class servletuservalid extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String u=request.getParameter("u");
		String p=request.getParameter("p");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","anand","password");
Statement stmt=conn.createStatement();
String sql = "SELECT * FROM user WHERE name=\""+u+"\" and pass=\""+p+"\"";
ResultSet rs=stmt.executeQuery(sql);
if(rs.next()){
out.println("Welcome"+u);}
else{
out.println("invalid credentials");
RequestDispatcher rd=request.getRequestDispatcher("user.html");
rd.include(request,response);
}
rs.close();
stmt.close();
conn.close();
}
catch(Exception e){
e.printStackTrace();
out.println("Error"+e);
}
out.close();
}
}

