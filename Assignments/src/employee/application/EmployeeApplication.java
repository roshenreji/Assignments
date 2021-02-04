package employee.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employee.entityClass.EmployeeDetails;
import employee.exception.IDPresentException;
import employee.service.EmployeeServiceImpl;

public class EmployeeApplication {

	Scanner sc=new Scanner(System.in);
	
	public void displayMessages() {
		System.out.println();
		System.out.println("These are the choices");
		System.out.println("1. Add Employee Details");
		System.out.println("2. Update Employee Salary by 1000 based on designation");
		System.out.println("3. Update Employee salary by 5000 based on years of experience");
		System.out.println("4. Delete an Employee by id");
		System.out.println("5. Display an employee by id");
		System.out.println("6. Display all employees");
		System.out.println("7. Exit");
	}
	public static void main(String[] args)  {
		
		Scanner sc=new Scanner(System.in);
		List<EmployeeDetails> employee=new ArrayList<>();
		EmployeeApplication obj=new EmployeeApplication();
		EmployeeServiceImpl service=new EmployeeServiceImpl();
		boolean isValid=true;
		do {
			obj.displayMessages();
			int choice=obj.sc.nextInt();
			switch(choice) {
			case 1:
				employee=service.addEmployee(employee);
				
				System.out.println();
				break;
			case 2:
				System.out.println("Enter the designation of those employees whose salary should be incremented by 1000");
				String designation=sc.nextLine();
				employee=service.updateEmployeeSalary(employee, designation);
				System.out.println("Updated");
				break;
			case 3:
				System.out.println("Enter the year of experience of those employees whose salary should be incremented by 5000");
				byte y_o_e=sc.nextByte();
				employee=service.updateEmployeeSalary(employee, y_o_e);
				break;
			case 4:
				System.out.println("Enter the id of the employee whose id you want to delete");
				short id=sc.nextShort();
				
				employee=service.deleteEmployeeById(employee, id);
				break;
			case 5:
				System.out.println("Enter the id of the employee whom you want to display");
				short idOfEmployee=sc.nextShort();
				EmployeeDetails temp=service.getEmployeeById(employee, idOfEmployee);
				try {
					System.out.println();
					System.out.println("\t Employee ID: "+temp.getId());
					System.out.println("\t Employee Name: "+temp.getName());
					System.out.println("\t Employee Designation: "+temp.getDesignation());
					System.out.println("\t Employee Salary: "+temp.getSalary());
					System.out.println("\t Employee Year Of Birth: "+temp.getY_o_e());
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 6:
				employee=service.getAllEmployee(employee);
				break;
			case 7:
				isValid=false;
				break;
				
				default:
					System.out.println("You have entered an invalid OPtion, Try again");
			}
		}
		while(isValid);

	}

}
