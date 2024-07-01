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
 * Servlet implementation class Delete_Stock
 */
public class Delete_Stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Stock() {
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

		String s_id=request.getParameter("s_id");
		String s_name=request.getParameter("s_name");
		String s_category=request.getParameter("s_category");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("delete from stock_tbl where s_id=? and s_name=? and s_category=?");
			ps1.setString(1,s_id);
			ps1.setString(2, s_name);
			ps1.setString(3, s_category);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				System.out.println("Delete Stock Successfully");
				response.sendRedirect("main_Page.html");
			}
			else
			{
				System.out.println("Failed To Delete Stock");
				response.sendRedirect("delete_Raw.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
