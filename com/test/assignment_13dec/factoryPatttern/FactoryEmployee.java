package com.test.assignment_12dec;

import java.time.LocalDate;

public class FactoryEmployee {
	public static Employee getEmployee() { // gives object of Employee class
		return new Employee();
	}

	public static FileOperations getCsvOperations() { // gives object of
														// CsvOperations class
		return new CsvOperations();
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
	public static FileOperations getTsvOperations() { // gives object of
		// TsvOperations class
return new TsvOperations();
}
}
