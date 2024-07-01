
package inventory_services;

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
 * Servlet implementation class Issued_Raw_Material
 */
public class Issued_Raw_Material extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Issued_Raw_Material() {
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
		//String i_id=request.getParameter("i_id");
		String r_name=request.getParameter("r_name");
		String r_category=request.getParameter("r_category");
		String i_quantity=request.getParameter("i_quantity");
		String issuer_name=request.getParameter("issuer_name");
		String item_id=request.getParameter("item_id");
		String i_date=request.getParameter("i_date");
		String i_time=request.getParameter("i_time");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into issued_tbl values(?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, r_name);
			ps1.setString(3, r_category);
			ps1.setString(4, i_quantity);
			ps1.setString(5, issuer_name);
			ps1.setString(6, item_id);
			ps1.setString(7, i_date);
			ps1.setString(8, i_time);
			
			int i=ps1.executeUpdate();
			if(i==1)
			{
				PreparedStatement ps2=con.prepareStatement("select * from raw_tbl where r_name=? and r_category=?");
				ps2.setString(1, r_name);
				ps2.setString(2, r_category);
				
				ResultSet rs =ps2.executeQuery();
				if(rs.next())
				{
					int a=Integer.parseInt(i_quantity);
					int b=rs.getInt("r_quantity");
					if(b>=a)
					{
						int r_quantity=b-a;
						PreparedStatement ps3=con.prepareStatement("update raw_tbl set r_quantity=? where r_name=? and r_category=?");
						ps3.setInt(1, r_quantity);
						ps3.setString(2, r_name);
						ps3.setString(3, r_category);
						int x=ps3.executeUpdate();
						if(x==1)
						{
							response.sendRedirect("view_Issued_Raw.jsp");
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
