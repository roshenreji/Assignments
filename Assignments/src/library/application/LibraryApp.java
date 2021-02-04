package library.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import library.FileHandling.FileHandler;
import library.entityClass.UserDetails;
import library.exception.PasswordMatchException;
import library.jdbcConnection.JDBCConnection;

public class LibraryApp {

	Scanner sc=new Scanner(System.in);
	public void displayMessages() {
		System.out.println();
		System.out.println("These are the choices: ");
		System.out.println("1. SignUp");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	public List adduserDetails(List<UserDetails> users) {
		System.out.println("Enter UserID: ");
		int userId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter UserName: ");
		String userName=sc.nextLine();
		System.out.println("Enter Role of the User");
		String role=sc.next();
		System.out.println("Enter contact Number: ");
		String mobileNumber=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
		
		users.add(new UserDetails(userId,userName,role,mobileNumber,password));
		
		return users;
		
	}
	
	public void passwordValidation(List<UserDetails> users,String userName,String password) throws PasswordMatchException {
		
		Iterator<UserDetails> it=users.iterator();
		UserDetails temp;
		boolean flag=false;
		String tempUserName="",tempPassword="";
		while(it.hasNext()) {
			temp=it.next();
			tempUserName=temp.getUserName();
			tempPassword=temp.getPassword();
			if(tempUserName.equals(userName)&&tempPassword.equals(password)) {
				flag=true;
				break;
			}
				
		}
		
		if(flag==true) {
			System.out.println();
			System.out.println("Sign In Successfull");
		}
		else
			throw new PasswordMatchException("Invalid User");
	}
	public String roleOftheUser(List<UserDetails> users) {
		Iterator<UserDetails>it=users.iterator();
		String role="";
		UserDetails temp;
		while(it.hasNext()) {
			temp=it.next();
			role=temp.getRole();
		}
		
		return role;
	}
	public static void main(String[] args) {
		JDBCConnection connection=new JDBCConnection();
		LibraryApp obj=new LibraryApp();
		StudentPanel student=new StudentPanel();
		AdminPanel admin=new AdminPanel();
		FileHandler file=new FileHandler();
		Date date=new Date();
		boolean valid=true;
		int firstTime=1;
		List<UserDetails> users=new ArrayList<UserDetails>();
		do {
			obj.displayMessages();
			int choice=obj.sc.nextInt();
			obj.sc.nextLine();
			
			switch(choice) {
			case 1:
				users=obj.adduserDetails(users);
				firstTime++;
				break;
			case 2:
				if(firstTime!=1) {
					System.out.println("Enter UserName");
					String userName=obj.sc.nextLine();
					System.out.println("Enter the password");
					String password=obj.sc.next();
					try {
						obj.passwordValidation(users,userName,password);
						try {
							String currentDate=date.toString();
							file.createFile(users,currentDate);
							Connection con=connection.connectToServer();
							String role=obj.roleOftheUser(users);
							if(role.equals("Student")||role.equals("student"))
								student.performOperations(con,users);
							else 
								admin.performOperations(con,users);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						finally {
							if (connection.con != null) {
								try {
									connection.con.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
									
								}
							}
						}
						
							
						
					} catch (PasswordMatchException e) {
						System.out.println(e.getMessage());
					}
					
					
				}
				else
					System.out.println("You have to Sign-Up first");
				break;
			case 3:
				valid=false;
				
				break;
				default:System.out.println("Invalid Entry, please Try Again");

					
				}
			
		}
		while(valid);

	}

}
