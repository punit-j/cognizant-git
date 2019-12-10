package com.wellsfargo.employee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.lang.Integer;

/**
 * Class containing list of Employees and different functions
 * 
 * @author 765337
 *
 */
public class SortList {

	public static void main(String[] args) {
		ArrayList<Employee> empl = new ArrayList<Employee>(); // Employee list declaration

		empl.add(new Employee("Punit", "Mumbai", 22000, LocalDateTime.of(1997, 02, 24, 06, 30))); // adding Employee
																									// data to the list
		empl.add(new Employee("Sujeet", "Pune", 2000, LocalDateTime.of(1997, 06, 20, 02, 00)));
		empl.add(new Employee("Vibhu", "Amritsar", 2400, LocalDateTime.of(1996, 12, 23, 11, 00)));
		empl.add(new Employee("Palak", "Surat", 1900, LocalDateTime.of(1997, 07, 22, 05, 00)));
		empl.add(new Employee("Pankhuri", "Pune", 8000, LocalDateTime.of(1997, 9, 9, 00, 00)));
		empl.add(new Employee("Mrunali", "Pune", 21000, LocalDateTime.of(1997, 8, 12, 07, 30)));
		empl.add(new Employee("Johnny Depp", "LA", 500, LocalDateTime.of(1980, 01, 01, 04, 30)));
		empl.add(new Employee("Martin Garrix", "Pune", 2000, LocalDateTime.of(1970, 05, 11, 22, 30)));
		empl.add(new Employee("Navin", "Hyderabad", 2200, LocalDateTime.of(1997, 07, 21, 21, 30)));
		empl.add(new Employee("Tony Stark", "Gotham", 250, LocalDateTime.of(1980, 05, 2, 15, 30)));

		Scanner sc = new Scanner(System.in);
		System.out.println("What do you want to do(avgSalary/sortSalaryDesc/searchCity/sortDobAsc");
		String operation = sc.nextLine(); // Input for function to perform
		// Calling the required method to perform the function
		if (operation.equals("avgSalary"))
			System.out.println(avgSalary(empl));
		if (operation.equals("sortSalaryDesc"))
			System.out.println(sortSalary(empl));
		if (operation.equals("searchCity")) {
			System.out.println("Enter City");
			String city = sc.nextLine();
			System.out.println(searchCity(city, empl));
		}
		if (operation.equals("sortDobAsc"))
			System.out.println(sortDOB(empl));
		sc.close();
	}

	private static ArrayList<Employee> sortDOB(ArrayList<Employee> empl) { // method to sort date of birth in ascending
																			// order
		Collections.sort(empl, new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
				if (o1.getDob().isEqual(o2.getDob()))
					return 0;
				if (o1.getDob().isBefore(o2.getDob()))
					return -1;
				else
					return 1;
			}
		});
		return empl;
	}

	private static ArrayList<Employee> searchCity(String city, ArrayList<Employee> empl) { // method to search city
		ArrayList<Employee> emplSearch = new ArrayList<Employee>();
		for (Employee e : empl) {
			if (city.equals(e.getCity()))
				emplSearch.add(e);
		}
		return emplSearch;
	}

	private static ArrayList<Employee> sortSalary(ArrayList<Employee> empl) { // method to sort salary in descending
																				// order
		Collections.sort(empl, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return Integer.compare(o2.getSalary(), o1.getSalary());
			}
		});
		return empl;
	}

	private static int avgSalary(ArrayList<Employee> empl) { // method to calculate average salary
		int sum = 0, counter = 0;
		for (Employee e : empl) {
			sum += e.getSalary();
			counter++;
		}
		return sum / counter;
	}

}
