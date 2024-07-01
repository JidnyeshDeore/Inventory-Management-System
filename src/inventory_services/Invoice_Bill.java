package inventory_services;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory_connection.ConnectDB;

/**
 * Servlet implementation class Invoice_Bill
 */
public class Invoice_Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Invoice_Bill() {
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
		String p_name=request.getParameter("p_name");
		String p_hsn=request.getParameter("p_hsn");
		String p_gstin=request.getParameter("p_gstin");
		String p_quantity=request.getParameter("p_quantity");
		String p_rate=request.getParameter("p_rate");
		//String p_tax_val=request.getParameter("p_tax_val");
		String p_gst=request.getParameter("p_gst");
		//String p_total=request.getParameter("p_total");
		String p_date=request.getParameter("p_date");
		
		float a=Float.parseFloat(p_quantity);
		float b=Float.parseFloat(p_rate);
		float c=Float.parseFloat(p_gst);
		float p_tax_val=(a*b);
		float d=(p_tax_val)*((c)/(100));
		float p_total=p_tax_val+d;
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into invoice_tbl values(?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, p_name);
			ps1.setString(3, p_hsn);
			ps1.setString(4, p_gstin);
			ps1.setString(5, p_quantity);
			ps1.setString(6, p_rate);
			ps1.setFloat(7,  p_tax_val);
			ps1.setString(8, p_gst);
			ps1.setFloat(9,  p_total);
			ps1.setString(10, p_date);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				
				System.out.println("Product Added");
				response.sendRedirect("view_Invoice.jsp");
			}
			else
			{
				
				System.out.println("Stock failed to added");
				response.sendRedirect("index.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
