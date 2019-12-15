package com.test.filehandling;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Employee class containing name, salary, city and date of birth of employees
 * 
 * @author 765337
 *
 */
public class Employee {
	String name, city; // attributes of Employee class
	int salary,age;
	LocalDate dob;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", salary=" + salary + ", age=" + age + ", dob=" + dob
				+ "]";
	}

	public Employee(String name, int age, LocalDate dob, int salary, String city) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
		this.age = age;
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	public Employee() { // default constructor
		super();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// getter setter start
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	} // getter setter end
}