package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Connector;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String password=request.getParameter("psw");
		
		System.out.println(username);
		System.out.println(password);
		
		Connection con=Connector.connection();
		String query="select * from login";
		
		try{
			
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			if(rs.getString(1).equals(username)&& rs.getString(2).equals(password))
			{
				rs.getString(1);
			PrintWriter out=response.getWriter();
			out.println("WELCOME");
			}
			
			else {
				PrintWriter out=response.getWriter();
				out.println("INVALID USER");
			}
		}
		
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
