package com.test.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reads file and performs different operations to the data
 * 
 * @author Punit
 *
 */
public class FileOperations {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>(
				readCSV("/A.csv"));
		System.out.println(sortDobDesc(list));
		System.out.println(lowestPaidEmployee(list));
		String city = "S";
		System.out.println(avgSalary(city, list));
	}

	private static float avgSalary(String city, List<Employee> list) { // calculates
																		// average
																		// salary
																		// of
																		// Employees
																		// based
																		// on
																		// city
		int sum = 0, counter = 0;
		for (Employee e : list) {
			if (e.getCity().equals(city)) {
				sum += e.getSalary();
				counter++;
			}
		}
		return sum / counter;
	}

	private static List<Employee> lowestPaidEmployee(List<Employee> list) { // Finds
																			// the
																			// lowest
																			// paid
																			// Employee
		List<Integer> salary = new ArrayList<>();
		list.forEach(i -> salary.add(i.getSalary()));
		int minSalary = Collections.min(salary);
		List<Employee> leastPaid = new ArrayList<>();
		for (Employee e : list) {
			if (e.getSalary() == minSalary)
				leastPaid.add(e);
		}
		return leastPaid;
	}

	private static List<Employee> sortDobDesc(List<Employee> list) { // Sorts
																		// the
																		// Employee
																		// data
																		// based
																		// on
																		// dob
																		// in
																		// descending
																		// order
		list.sort((o1, o2) -> o2.getDob().compareTo(o1.getDob()));
		return list;
	}

	private static List<Employee> readCSV(String string) { // reads the .csv
															// file and store
															// the data in List
															// of Employees
		List<Employee> list = new ArrayList<Employee>();
		try (BufferedReader reader = new BufferedReader(new FileReader(string))) {
			String row = reader.readLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			while ((row = reader.readLine()) != null) {
				String[] data = row.split(",");
				Employee e = new Employee(data[0], Integer.parseInt(data[1]), LocalDate.parse(data[2], formatter),
						Integer.parseInt(data[3]), data[4]);
				list.add(e);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
