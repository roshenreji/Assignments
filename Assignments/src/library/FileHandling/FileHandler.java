package library.FileHandling;

import java.io.BufferedWriter;
import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import library.entityClass.UserDetails;

public class FileHandler {

	public void writeLogIn(List<UserDetails> users, String date) {
		try {
			UserDetails temp;
			int id = 0;
			String name = "", role = "";
			Iterator<UserDetails> it = users.iterator();
			while (it.hasNext()) {
				temp = it.next();
				id = temp.getUserId();
				name = temp.getUserName();
				role = temp.getRole();
			}
			PrintWriter myWriter = new PrintWriter(
					"C:\\Users\\\\roshe\\eclipse-workspace\\Assignments\\src\\library\\FileHandling\\filename.txt");
			myWriter.println(id + " " + name + " " + role + " has logged out at " + date);

			myWriter.write("HelloWorld");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeLogOut(List<UserDetails> users, String date) {
		try {
			UserDetails temp;
			int id = 0;
			String name = "", role = "";
			Iterator<UserDetails> it = users.iterator();
			while (it.hasNext()) {
				temp = it.next();
				id = temp.getUserId();
				name = temp.getUserName();
				role = temp.getRole();
			}
			PrintWriter myWriter = new PrintWriter(
					"C:\\Users\\\\roshe\\eclipse-workspace\\Assignments\\src\\library\\FileHandling\\filename.txt");
			myWriter.println(id + " " + name + " " + role + " has logged out at " + date);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void createFile(List<UserDetails> users, String date) {
		try {
			File myObj = new File(
					"C:\\Users\\roshe\\eclipse-workspace\\Assignments\\src\\library\\FileHandling\\filename.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}

			writeLogIn(users, date);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			System.out.println(e.getMessage());
		}
	}

}