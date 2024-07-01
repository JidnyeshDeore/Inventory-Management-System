package inventory_services;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Raw_Update
 */
public class Raw_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Raw_Update() {
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
		String r_quantity=request.getParameter("r_quantity");
		String r_unit=request.getParameter("r_unit");
		String r_cost_per_unit=request.getParameter("r_cost_per_unit");
		String r_date=request.getParameter("r_date");
		
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("update raw_tbl set r_id=?, r_name=?,r_quantity=?,r_unit=?,r_cost_per_unit=?,r_date=?");
			ps1.setString(1, r_id);
			ps1.setString(2, r_name);
			ps1.setString(3, r_quantity);
			ps1.setString(4, r_unit);
			ps1.setString(5, r_cost_per_unit);
			ps1.setString(6, r_date);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				
				System.out.println("raw Material updated");
				response.sendRedirect("main_Page.html");
			}
			else
			{
				
				System.out.println("raw Material failed to update");
				response.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
