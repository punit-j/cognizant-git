package com.test.factorypattern;

import java.time.LocalDate;

/**
 * Factory class to create instances of Employee and FileOperation class
 * 
 * @author Punit
 *
 */
public class FactoryEmployee {
	public static Employee getEmployee() { // gives object of Employee class
		return new Employee();
	}

	public static FileOperations getFileOperations() { // gives object of
														// FileOperations class
		return new FileOperations();
	}

	public static Employee getEmployee(String name, int age, LocalDate dob, int salary, String city) { // gives
																										// object
																										// of
																										// Employee
																										// class
																										// with
																										// attributes
																										// values
		Employee e = new Employee();
		e.setAge(age);
		e.setCity(city);
		e.setDob(dob);
		e.setName(name);
		e.setSalary(salary);
		return e;
	}
}
