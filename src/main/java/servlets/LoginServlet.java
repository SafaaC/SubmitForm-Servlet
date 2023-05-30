package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
		
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
			}
			else{
				out.println("<h2>You have Not Accepted the Conditions</h2>");
			}
			
			
			//JDBC
			
		}
}
