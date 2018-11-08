import java.io.*;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Dparser {
  public static void main(String[]args) {
	  try {
	  Scanner sc=new Scanner(System.in);
	  File inputFile=new File("users.xml");
	  DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
	  Document doc=dBuilder.parse(inputFile);
	  doc.getDocumentElement().normalize();
	  System.out.println("enter the user_id of student");
	  String Uid=sc.next();
	  System.out.println("Root element:"+ doc.getDocumentElement().getNodeName());
	  NodeList nList=doc.getElementsByTagName("student");
	  System.out.println("..........................");
	  int c=0;
	  for(int temp=0;temp<nList.getLength();temp++)
	  {
		  Node nNode=nList.item(temp);
		  if(nNode.getNodeType()==Node.ELEMENT_NODE) {
			  Element eElement=(Element)nNode;
			  if(eElement.getElementsByTagName("rollno").item(0).getTextContent().equals(Uid)) {
				  System.out.println("Student Rollno:"+eElement.getElementsByTagName("rollno").item(0).getTextContent());
				  System.out.println("Student Name:"+eElement.getElementsByTagName("name").item(0).getTextContent());
				  System.out.println("Student Marks:"+eElement.getElementsByTagName("marks").item(0).getTextContent());
				  System.out.println("Student Gender:"+eElement.getElementsByTagName("gender").item(0).getTextContent());
			  c=1;
			  }
			  
		  }
		  
	  }
	  if(c==0)
		  System.out.println("the given userid"+Uid+"is not present in xml document");
  }
  catch(Exception e) {
	  e.printStackTrace();
  }
}
}
