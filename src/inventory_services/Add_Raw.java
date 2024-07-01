package inventory_services;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Add_Raw
 */
public class Add_Raw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Raw() {
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
		String r_name=request.getParameter("r_name");
		String r_category=request.getParameter("r_category");
		String r_quantity=request.getParameter("r_quantity");
		String r_unit=request.getParameter("r_unit");
		String r_cost_per_unit=request.getParameter("r_cost_per_unit");
		String r_date=request.getParameter("r_date");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into raw_tbl values(?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, r_name);
			ps1.setString(3, r_category);
			ps1.setString(4, r_quantity);
			ps1.setString(5, r_unit);
			ps1.setString(6, r_cost_per_unit);
			ps1.setString(7, r_date);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				
				System.out.println("raw Material Added");
				response.sendRedirect("view_Raw.jsp");
			}
			else
			{
				
				System.out.println("raw Material failed");
				response.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
