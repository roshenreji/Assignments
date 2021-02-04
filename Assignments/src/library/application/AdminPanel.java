package library.application;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import library.FileHandling.FileHandler;
import library.entityClass.UserDetails;
import library.service.StaffInterfaceImplementation;

public class AdminPanel {

	Scanner sc=new Scanner(System.in);
	public void displayMessages() {
		System.out.println();
		System.out.println("These are the choices: ");
		System.out.println("1. Add the book");
		System.out.println("2. Update the book quantity");
		System.out.println("3. Delete book by id");
		System.out.println("4. Get book by id");
		System.out.println("5. Display all books");
		System.out.println("6. Logout");
		
	}
	public void performOperations(Connection con,List<UserDetails> users) {
		boolean isValid=true;
		FileHandler file=new FileHandler();
		StaffInterfaceImplementation obj=new StaffInterfaceImplementation();
		do {
			displayMessages();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				obj.addBook(con);
				break;
			case 2:
				System.out.println("Enter the id of the book you want to update ");
				int id=sc.nextInt();
				System.out.println("Enter the new quantity of the book: ");
				int quantity=sc.nextByte();
				obj.updateBookQuantity(id, quantity,con);
				break;
			case 3:
				System.out.println("Enter the id of the book you want to delete ");
				int idToBeDeleted=sc.nextInt();
				obj.deleteBookById(idToBeDeleted,con);
				break;
			case 4:
				System.out.println("Enter the id of the book that needs to be displayed");
				int idTobeDisplayed=sc.nextInt();
				obj.getBookById(idTobeDisplayed,con);
				break;
				
			case 5:
				System.out.println("Display all the books: ");
				obj.getAllBooks(con);
				break;
			case 6:
				isValid=false;
				Date date=new Date();
				String logOutTime=date.toString();
				file.writeLogOut(users,logOutTime);
				break;
			}
		}
		while(isValid);
	}

}
