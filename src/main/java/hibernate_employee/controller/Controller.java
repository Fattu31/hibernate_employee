package hibernate_employee.controller;

import java.util.Scanner;

import hibernate_employee.dao.EmployeeDao;
import hibernate_employee.dto.Employee;

public class Controller {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		EmployeeDao dao = new EmployeeDao();
		boolean condition = true;
		do {
			System.out.println("Enter the choice \n 1.Save Employee \n 2.Update \n 3.Delete \n 4.FetchAll \n 5.FetchDataByPhone \n 6.FetchDataByEmail \n 7.FetchDataByDesignation");
			switch (scanner.nextInt()) {
			case 1: {
				System.out.println("Enter the id");
				employee.setId(scanner.nextInt());
				System.out.println("Enter the Name");
				employee.setName(scanner.next());
				System.out.println("Enter the Email");
				employee.setEmail(scanner.next());
				System.out.println("Enter the Phone");
				employee.setPhone(scanner.nextLong());
				System.out.println("Enter the Salary");
				employee.setSalary(scanner.nextDouble());
				System.out.println("Enter the Designation");
				employee.setDesignation(scanner.next());
				dao.saveEmployee(employee);

			}
				break;
			case 2: {
				System.out.println("Enter the id");
				int id = scanner.nextInt();
				System.out.println("Enter the Name");
				employee.setName(scanner.next());
				System.out.println("Enter the Email");
				employee.setEmail(scanner.next());
				System.out.println("Enter the Phone");
				employee.setPhone(scanner.nextLong());
				System.out.println("Enter the Salary");
				employee.setSalary(scanner.nextDouble());
				System.out.println("Enter the Designation");
				employee.setDesignation(scanner.next());
				dao.update(id, employee);
			}
				break;
			case 3: {
				System.out.println("Enter the id");
				int id = scanner.nextInt();
				dao.delete(id);
			}
				break;
			case 4: {
				dao.fetchAll(employee);
			}
				break;
			case 5: {
				System.out.println("Enter the Phone");
				long phone = scanner.nextLong();
				dao.fetchDataByPhone(phone);
			}
				break;
			case 6: {
				System.out.println("Enter the Email");
				String email = scanner.next();
				dao.fetchDataByEmail(email);
			}
				break;
			case 7: {

				System.out.println("Enter the Designation");
				String designation = scanner.next();
				dao.designation(designation);
			}
				break;
			default:
				System.out.println("Logout");
				break;
			}

		} while (condition);

	}
}