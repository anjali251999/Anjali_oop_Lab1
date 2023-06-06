package com.greatlearning.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmployeeServiceImpl;

public class Driverapp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your First Name");
		String fName = sc.next();
		System.out.println("Enter your Last Name");
		String LName = sc.next();
		
		Employee emp = new Employee();
		emp.setFirstName(fName);
		emp.setLastName(LName);
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		
		System.out.println("1.Technical");
		System.out.println("2.Admin");
		System.out.println("3.HR");
		System.out.println("1.Legal");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		String gEmail = "";
		String gPassword = "";
		switch(choice)
		{
		case 1 : gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "tech");
			break;
		case 2:  gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "admin"); 
				break;
		case 3 : gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "hr");
			break;
		case 4 : gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "legal");
			break;
		default: System.out.println("Please enter valid input");	
			}
		
		gPassword = esi.generateUserPassword();
		emp.setUserEmail(gEmail);
		emp.setPassword(gPassword);
		esi.displayEmployeeDetails(emp);
						
			
	}
}


