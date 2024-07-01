package inventory_connection;
import java.sql.*;

import com.mysql.jdbc.Connection;
public class ConnectDB {
	
	static java.sql.Connection con=null;;
	public static Connection connect() 
	{
		
		if(con==null) 
		{	
			try 
			{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_db","root","");
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong..");
				e.printStackTrace();
			}

		}
		return (Connection) con;
	}
}
