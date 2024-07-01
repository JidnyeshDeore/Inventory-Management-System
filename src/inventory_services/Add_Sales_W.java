package inventory_services;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Add_Sales_W
 */
public class Add_Sales_W extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Sales_W() {
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
		String s_email=request.getParameter("s_email");
		String w_product=request.getParameter("w_product");
		String w_category=request.getParameter("w_category");
		String w_quantity=request.getParameter("w_quantity");
		String c_name=request.getParameter("c_name");
		String w_date=request.getParameter("w_date");
		
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into sales_work_tbl values(?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, s_name);
			ps1.setString(3, s_email);
			ps1.setString(4, w_product);
			ps1.setString(5, w_category);
			ps1.setString(6, w_quantity);
			ps1.setString(7, c_name);
			ps1.setString(8, w_date);
			
			
			int i=ps1.executeUpdate();
			if(i==1)
			{
				PreparedStatement ps2=con.prepareStatement("select * from issued_stock_tbl where s_name=? and i_quantity=?");
				ps2.setString(1, w_product);

				ps2.setString(2, w_quantity);
				
				ResultSet rs =ps2.executeQuery();
				if(rs.next())
				{
					int a=Integer.parseInt(w_quantity);
					int b=rs.getInt("i_quantity");
					if(b>=a)
					{
						int i_quantity=b-a;
						PreparedStatement ps3=con.prepareStatement("update issued_stock_tbl set i_quantity=? where s_name=? ");
						ps3.setInt(1, i_quantity);
						ps3.setString(2, w_product);
						
						int x=ps3.executeUpdate();
						if(x==1)
						{
							response.sendRedirect("View_Sales_Work.jsp");
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
