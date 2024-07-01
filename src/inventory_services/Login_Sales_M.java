package inventory_services;
import java.sql.*;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Login_Sales_M
 */
public class Login_Sales_M extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Sales_M() {
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
		String s_email=request.getParameter("s_email");
		String s_pass=request.getParameter("s_pass");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("select * from sales_tbl where s_email=? and s_pass=?");
			ps1.setString(1, s_email);
			ps1.setString(2, s_pass);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("sales_Work.html");
				System.out.println("Successfully Manager Login...");
			}
			else
			{
				response.sendRedirect("login_Sales.html");
				System.out.println("Failed To login");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
