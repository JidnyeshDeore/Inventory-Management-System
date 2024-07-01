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
 * Servlet implementation class Delete_Raw
 */
public class Delete_Raw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Raw() {
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
		
		String r_id=request.getParameter("r_id");
		String r_name=request.getParameter("r_name");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("delete from raw_tbl where r_id=? and r_name=?");
			ps1.setString(1,r_id);
			ps1.setString(2, r_name);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				System.out.println("Delete Raw Material Successfully");
				response.sendRedirect("main_Page.html");
			}
			else
			{
				System.out.println("Failed To Delete Raw Material");
				response.sendRedirect("delete_Raw.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
