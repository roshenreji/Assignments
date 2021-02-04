package library.service;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;
import library.exception.IdAbsentException;
import library.exception.IdPresentException;
import library.jdbcConnection.JDBCConnection;

public class StaffInterfaceImplementation implements StaffInterface {

	JDBCConnection obj = new JDBCConnection();
	Scanner sc = new Scanner(System.in);

	public void checkIdPresence(int id,Connection con) throws IdPresentException {
		int count = 0;
		boolean valid = false;
		try {

			
			String query = "Select id from Library Where Id=" + id;
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
				if (count == id) {
					valid = true;
					break;
				}
			}

			

			if (valid == true) {
				throw new IdPresentException("Already Present");
			}

			if (ps != null) {
				ps.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public void checkIdAbsence(int id,Connection con) throws IdAbsentException {
		int count = 0;
		boolean valid = false;
		try {

			
			String query = "Select id from Library Where Id=" + id;
			PreparedStatement ps = con.prepareStatement(query);

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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 

	}

	@Override
	public void addBook(Connection con) {
		try {
			System.out.println("Enter the id of the Book: ");
			int id = sc.nextInt();
			checkIdPresence(id,con);
			sc.nextLine();
			System.out.println("Enter Name of the Book");
			String name = sc.nextLine();
			System.out.println("Enter the Author's Name in to the Book");
			String authorName = sc.nextLine();
			System.out.println("Enter the quantity of the Book");
			int quantity = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Genre of the book");
			String genre = sc.nextLine();

			
			String query = "Insert into Library values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, authorName);
			ps.setInt(4, quantity);
			ps.setString(5, genre);

			ps.executeUpdate();

			if (ps != null) {
				ps.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 

	}

	@Override
	public void updateBookQuantity(int id, int quantity,Connection con) {
		
		try {
			checkIdAbsence(id,con);
			try {

				
				
				String query = "Update Library Set Quantity=" + quantity + " Where Id=" + id;
				PreparedStatement ps = con.prepareStatement(query);

				ps.executeUpdate();

				if (ps != null) {
					ps.close();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
		} catch (IdAbsentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		

	}

	@Override
	public void deleteBookById(int id,Connection con) {

		try {
			checkIdAbsence(id,con);
			try {

				
				String query = "DELETE from Library Where Id=" + id;
				PreparedStatement ps =con.prepareStatement(query);

				ps.executeUpdate();

				if (ps != null) {
					ps.close();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 

		} catch (IdAbsentException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

	}

	@Override
	public void getBookById(int id,Connection con) {

		try {
			checkIdAbsence(id,con);
			try {

				
				String query = "Select id,name,authorName,quantity,genre from Library Where Id=" + id;
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				if(rs.next()) {
					System.out.println();
					System.out.println(  "\t Book Id: " + rs.getInt(1));
					System.out.println("\t Book Name: " + rs.getString(2));
					System.out.println("\t Book Author: " + rs.getString(3));
					System.out.println("\t Quantity: " + rs.getInt(4));
					System.out.println("\t Genre: " + rs.getString(5));
				}
				
				

				if (rs != null) {
					rs.close();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 

		} catch (IdAbsentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void getAllBooks(Connection con) {

		try {

			int count = 1;
			
			String query = "Select id,name,authorName,quantity,genre from Library";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println();
				System.out.println(count + "\t Book Id: " + rs.getInt(1));
				System.out.println("\t Book Name: " + rs.getString(2));
				System.out.println("\t Book Author: " + rs.getString(3));
				System.out.println("\t Quantity: " + rs.getInt(4));
				System.out.println("\t Genre: " + rs.getString(5));
				count++;
			}

			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 

	}

}
