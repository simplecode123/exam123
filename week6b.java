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
ServletConfig config=getServletConfig();
String name=config.getInitParameter("username");
String pass=config.getInitParameter("password");
if(u.equals(name)&&p.equals(pass))
out.print("Welcome");
else
{
out.print("error");
RequestDispatcher rd=request.getRequestDispatcher("login.html");
rd.include(request,response);
}
out.close();
}
}
