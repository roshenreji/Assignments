package library.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import library.FileHandling.FileHandler;
import library.entityClass.UserDetails;
import library.exception.IdAbsentException;
import library.jdbcConnection.JDBCConnection;

public class StudentPanel {

	Scanner sc = new Scanner(System.in);
	JDBCConnection obj = new JDBCConnection();

	public void checkIdAbsence(int id,Connection con) throws Exception {
		int count = 0;
		boolean valid = false;
		

			String query = "Select id from Library Where Id=" + id;
			PreparedStatement ps =con.prepareStatement(query);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
				if (count == id) {
					valid = true;
					break;
				}
			}

			

			if (valid == false) {
				throw new IdAbsentException("Entry Not Found");
			}

			if (ps != null) {
				ps.close();
			}

		

	}

	public void displayMessages() {
		System.out.println();
		System.out.println("These are the choices:");
		System.out.println("1. View Book Details");
		System.out.println("2. Purchase the book by Id");
		System.out.println("3. Logout");
	}

	public void viewBookDetails(Connection con) {
		try {

			int count = 1;
			String query = "Select id,name,authorName,quantity,genre from Library";
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery(query);

			System.out.println("Books Availabe are: ");
			while (rs.next()) {
				System.out.println(count + "\t Book Id: " + rs.getInt(1));
				System.out.println("\t Book Name: " + rs.getString(2));
				System.out.println("\t Book Author: " + rs.getString(3));
				System.out.println("\t Quantity: "+rs.getInt(4));
				System.out.println("\t Genre: " + rs.getString(5));
			}

			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 

	}
	
	public int getQuantityOfBook(int id,Connection con) {
		
		int quantity=0;
			try {

				
				String query = "Select quantity from Library Where id=" + id;
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);

				
				
				while(rs.next()) {
					quantity=rs.getInt("quantity");
					System.out.println(quantity);
					//System.out.println(rs.getInt("id"));
				}

				rs.close();
				st.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
			return quantity;

		

	}
	
	public void purchase(int id,Connection con) {
		try {

			
			int quantity=getQuantityOfBook(id,con);
			int newQuantity=quantity-1;
			String query = "Update Library Set Quantity=" + newQuantity + " Where Id=" + id;
			PreparedStatement ps = con.prepareStatement(query);

			ps.executeUpdate();

			if (ps != null) {
				ps.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	}

	public void performOperations(Connection con,List<UserDetails> users) {
		boolean isValid=true;
		FileHandler file=new FileHandler();
		do {
			displayMessages();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

				
				viewBookDetails(con);
				break;
			case 2:
				System.out.println("Enter the id of the book you want to purhcase: ");
				int id = sc.nextInt();
				
				try {
					checkIdAbsence(id,con);
					purchase(id,con);
					viewBookDetails(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					
				break;
				
				
			case 3:
				isValid=false;
				Date date=new Date();
				String logOutTime=date.toString();
				file.writeLogOut(users,logOutTime);
				break;
				default:System.out.println("Invalid Option, Please try again");
			}	
		}
		while(isValid);
		
			
		
			
		
	}

}
