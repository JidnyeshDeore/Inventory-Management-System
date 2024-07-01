package inventory_services;
import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Add_Sales_M
 */
public class Add_Sales_M extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Sales_M() {
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
		String s_name=request.getParameter("s_name");
		String s_city=request.getParameter("s_city");
		String s_email=request.getParameter("s_email");
		String s_mob=request.getParameter("s_mob");
		String s_pass=request.getParameter("s_pass");
		String s_date=request.getParameter("s_date");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into sales_tbl values(?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, s_name);
			ps1.setString(3, s_city);
			ps1.setString(4, s_email);
			ps1.setString(5, s_mob);
			ps1.setString(6, s_pass);
			ps1.setString(7, s_date);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				
				System.out.println("Sales manager Added");
				response.sendRedirect("View_Sales_M.jsp");
			}
			else
			{
				
				System.out.println("Manager  failed to added");
				response.sendRedirect("error.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
