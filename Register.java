

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
		public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	  
	response.setContentType("text/html");  
	PrintWriter out = response.getWriter();  
	          
	String n=request.getParameter("userName");  
	String p=request.getParameter("userPass");  
	String e=request.getParameter("userEmail");  
	String c=request.getParameter("userCountry");  
	          
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/registeruser","root","root");  
	  
	PreparedStatement ps=con.prepareStatement(  
	"insert into registeruser values(?,?,?,?)");  
	  
	ps.setString(1,n);  
	ps.setString(2,p);  
	ps.setString(3,e);  
	ps.setString(4,c);  
	          
	int i=ps.executeUpdate();  
	if(i>0)  
	out.print("You are successfully registered...");  
	      
	          
	}catch (Exception e2) {System.out.println(e2);}  
	          
	out.close();  
	}  
	}

