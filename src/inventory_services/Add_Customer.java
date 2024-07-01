package inventory_services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Add_Customer
 */
public class Add_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Customer() {
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
		String c_name=request.getParameter("c_name");
		String c_email=request.getParameter("c_email");
		String c_mob=request.getParameter("c_mob");
		String c_buy_prod=request.getParameter("c_buy_prod");
		String c_quantity=request.getParameter("c_quantity");
		String c_date=request.getParameter("c_date");
		
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into customer_tbl values(?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, c_name);
			ps1.setString(3, c_email);
			ps1.setString(4, c_mob);
			ps1.setString(5, c_buy_prod);
			ps1.setString(6, c_quantity);
			ps1.setString(7,  c_date);
		
			int i=ps1.executeUpdate();
			if(i==1)
			{
				
				System.out.println("Customer Added");
				response.sendRedirect("view_Customer.jsp");
			}
			else
			{
				
				System.out.println("customer failed to added");
				response.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
