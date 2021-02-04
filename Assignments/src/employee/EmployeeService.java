package employee;


import java.util.List;

import employee.entityClass.*;
import employee.exception.IDPresentException;

public interface EmployeeService {

	public List addEmployee(List<EmployeeDetails> employee) throws IDPresentException;
	public List updateEmployeeSalary(List<EmployeeDetails> employee,String designation);
	public List updateEmployeeSalary(List<EmployeeDetails> employee,byte y_O_e);
	public List deleteEmployeeById(List<EmployeeDetails> employee,short id);
	public EmployeeDetails getEmployeeById(List<EmployeeDetails> employee,short id);
	public List getAllEmployee(List<EmployeeDetails> employee);
}
