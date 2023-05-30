package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<h1>Welcome To Register Servlet</h1>");
			
			String name=req.getParameter("user_name");
			String password=req.getParameter("user_password");
			String email=req.getParameter("user_email");
			String gender=req.getParameter("user_gender");
			String course=req.getParameter("user_course");
			String cond=req.getParameter("condition");
			
			if(cond!=null){
				out.println("<h2>Name : "+name+ "</h2>");
				out.println("<h2>Email : "+email+ "</h2>");
				out.println("<h2>Gender : "+gender+ "</h2>");
				out.println("<h2>Course : "+course+ "</h2>");
				
				

				//JDBC
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
					PreparedStatement statement =connection.prepareStatement("insert into login values (?,?,?,?,?)");
					statement.setString(1, name);
					statement.setString(2, password);
					statement.setString(3, email);
					statement.setString(4, gender);
					statement.setString(5, course);
					statement.execute();
					connection.close();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			else{
				out.println("<h2>You have Not Accepted the Conditions</h2>");
			}
			
			
			
			
		}
}
