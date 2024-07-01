package inventory_services;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Add_Stock
 */
public class Add_Stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Stock() {
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
		String s_category=request.getParameter("s_category");
		String s_quantity=request.getParameter("s_quantity");
		String s_bucket=request.getParameter("s_bucket");
		String s_cost_per_unit=request.getParameter("s_cost_per_unit");
		String s_date=request.getParameter("s_date");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into stock_tbl values(?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, s_name);
			ps1.setString(3, s_category);
			ps1.setString(4, s_quantity);
			ps1.setString(5, s_bucket);
			ps1.setString(6, s_cost_per_unit);
			ps1.setString(7, s_date);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				
				System.out.println("Stock Added");
				response.sendRedirect("view_Stock.html");
			}
			else
			{
				
				System.out.println("Stock failed to added");
				response.sendRedirect("main_Page.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
