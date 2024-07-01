package inventory_services;
import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Issued_Stock_Material
 */
public class Issued_Stock_Material extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Issued_Stock_Material() {
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
		String i_quantity=request.getParameter("i_quantity");
		String issuer_name=request.getParameter("issuer_name");
		String item_id=request.getParameter("item_id");
		String i_date=request.getParameter("i_date");
		String i_time=request.getParameter("i_time");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into issued_stock_tbl values(?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, s_name);
			ps1.setString(3, s_category);
			ps1.setString(4, i_quantity);
			ps1.setString(5, issuer_name);
			ps1.setString(6, item_id);
			ps1.setString(7, i_date);
			ps1.setString(8, i_time);
			
			int i=ps1.executeUpdate();
			if(i==1)
			{
				PreparedStatement ps2=con.prepareStatement("select * from stock_tbl where s_name=? and s_category=?");
				ps2.setString(1, s_name);
				ps2.setString(2, s_category);
				
				ResultSet rs =ps2.executeQuery();
				if(rs.next())
				{
					int a=Integer.parseInt(i_quantity);
					int b=rs.getInt("s_quantity");
					if(b>=a)
					{
						int s_quantity=b-a;
						PreparedStatement ps3=con.prepareStatement("update stock_tbl set s_quantity=? where s_name=? and s_category=?");
						ps3.setInt(1, s_quantity);
						ps3.setString(2, s_name);
						ps3.setString(3, s_category);
						int x=ps3.executeUpdate();
						if(x==1)
						{
							response.sendRedirect("View_Issued_Stock.jsp");
							System.out.println("Successfully updated");
						}
						else
						{
							System.out.println("failed to update raw table");
						}
					}
					else
					{
						response.sendRedirect("error.html");
					}
					
				}
				
			}
			else
			{
				
				System.out.println("failed to added issued raw");
				response.sendRedirect("error.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
