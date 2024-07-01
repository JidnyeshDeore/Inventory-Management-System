package inventory_services;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Admin_Login
 */
public class Admin_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		try
		{
			Connection con=ConnectDB.connect();
		
		
			if(uname.equals("admin@gmail.com") && upass.equals("admin"))
			{
				response.sendRedirect("main_Page.html");
				System.out.println("Successfully Admin Login...");
			}
			else
			{
				response.sendRedirect("index.html");
				System.out.println("Failed To login");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
