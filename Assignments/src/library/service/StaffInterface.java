package library.service;

import java.sql.Connection;
import java.util.List;

import library.entityClass.BookDetails;

public interface StaffInterface {


	public void addBook(Connection con);
	public void updateBookQuantity(int id,int quantity,Connection con);
	public void deleteBookById(int id,Connection con);
	public void getBookById(int id,Connection con);
	public void getAllBooks(Connection con);
	
}
