package library.jdbcConnection;

import java.sql.*;
public class JDBCConnection {

	public Connection con=null;
	public Connection connectToServer() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase", "root", "Helloworld1234");
		//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase", "root", "Helloworld1234");
		
		return con;
	}
}
