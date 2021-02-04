package employee.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import employee.EmployeeService;
import employee.entityClass.EmployeeDetails;
import employee.exception.IDAbsentException;
import employee.exception.IDPresentException;

public class EmployeeServiceImpl implements EmployeeService {

	Scanner sc = new Scanner(System.in);
	List<EmployeeDetails> employee = new ArrayList<>();

	public static void checkIdPresence(List<EmployeeDetails> e, short id) throws IDPresentException {
		boolean valid = true;
		Iterator<EmployeeDetails> itr = e.iterator();
		while (itr.hasNext()) {
			EmployeeDetails temp = itr.next();
			if (temp.getId() == id) {
				valid = false;
			}
		}
		if (!valid)
			throw new IDPresentException("Already Present");
		else
			System.out.println("Validated");
	}

	public static void checkIdAbsence(List<EmployeeDetails> e, short id) throws IDAbsentException {
		boolean valid = false;
		Iterator<EmployeeDetails> itr = e.iterator();
		while (itr.hasNext()) {
			EmployeeDetails temp = itr.next();
			if (temp.getId() == id) {
				valid = true;
			}
		}
		if (!valid)
			throw new IDAbsentException("Entry not found");
		else
			System.out.println("Validated");
	}

	@Override
	public List addEmployee(List<EmployeeDetails> employee) {
		System.out.println("Enter the employee id");
		short id = sc.nextShort();

		try {
			checkIdPresence(employee, id);
			sc.nextLine();
			System.out.println();
			System.out.println("Enter the Employee Name");
			String name = sc.nextLine();
			System.out.println("Enter the Employee Designation");
			String designation = sc.nextLine();
			System.out.println("Enter Employee Salary");
			double salary = sc.nextDouble();
			System.out.println("Enter Years Of Experience");
			byte y_o_e = sc.nextByte();

			employee.add(new EmployeeDetails(id, name, designation, salary, y_o_e));
			System.out.println("Employee added");

		} catch (IDPresentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return employee;

	}

	@Override
	public List updateEmployeeSalary(List<EmployeeDetails> employee, String designation) {

		Iterator<EmployeeDetails> it = employee.iterator();

		while (it.hasNext()) {
			EmployeeDetails temp;
			temp = it.next();
			if (temp.getDesignation().equals(designation)) {
				temp.setSalary(temp.getSalary() + 1000);

			}

		}

		return employee;
	}

	@Override
	public List updateEmployeeSalary(List<EmployeeDetails> employee, byte y_o_e) {
		Iterator<EmployeeDetails> it = employee.iterator();

		while (it.hasNext()) {
			EmployeeDetails temp;
			temp = it.next();
			if (temp.getY_o_e() >= y_o_e) {
				temp.setSalary(temp.getSalary() + 5000);

			}

		}

		return employee;
	}

	@Override
	public List deleteEmployeeById(List<EmployeeDetails> employee, short id) {
		try {
			checkIdAbsence(employee, id);
			Iterator<EmployeeDetails> it = employee.iterator();
			int index = 0;
			while (it.hasNext()) {
				EmployeeDetails temp;
				temp = it.next();
				if (temp.getId() == id) {
					employee.remove(index);

				}
				index++;
			}
		} catch (IDAbsentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

		return employee;
	}

	@Override
	public EmployeeDetails getEmployeeById(List<EmployeeDetails> employee, short id) {
		EmployeeDetails person = null;
		try {
			checkIdAbsence(employee, id);
			
			Iterator<EmployeeDetails> it = employee.iterator();
			int index = 0;
			while (it.hasNext()) {
				EmployeeDetails temp;
				temp = it.next();
				if (temp.getId() == id) {
					person = temp;
				}
			}
		} catch (IDAbsentException e) {
			System.out.println(e.getMessage());
		}
		
		return person;
	}

	@Override
	public List<EmployeeDetails> getAllEmployee(List<EmployeeDetails> employee) {

		int count = 1;
		Iterator<EmployeeDetails> it = employee.iterator();
		while (it.hasNext()) {
			EmployeeDetails temp;
			temp = it.next();
			System.out.println();
			System.out.println(count + "\t Employee ID: " + temp.getId());
			System.out.println("\t Employee Name: " + temp.getName());
			System.out.println("\t Employee Designation: " + temp.getDesignation());
			System.out.println("\t Employee Salary: " + temp.getSalary());
			System.out.println("\t Employee Year Of Birth: " + temp.getY_o_e());
			count++;
		}
		return employee;
	}

}
