import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Calculator extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
PrintWriter out = response.getWriter();
response.setContentType("text/html");
int n1=Integer.parseInt(request.getParameter("o1"));//request.getParameter("o1");
int n2=Integer.parseInt(request.getParameter("o2"));//request.getParameter("o2");
String op=request.getParameter("op");
//int n1,n2;
//n1=Integer.parseInt(o1);
//n2=Integer.parseInt(o2);
out.print(n1);
out.print(op);
out.print(n2);
out.print("=");
if(op.equals("+"))
{
out.print(n1+n2);
}
else  if(op.equals("-"))
{
out.print(n1-n2);
}
else if(op.equals("/"))
{
out.print(n1/n2);
}
else if(op.equals("*"))
{
out.print(n1*n2);
}
else
{
out.print("INVALID OPERATOR:PLEASE CHOOSE EITHER +,-,/,*");
}
out.close();
}
}
