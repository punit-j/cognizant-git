package com.test.assignment_12dec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TsvOperations implements FileOperations {

	@Override
	public List<Employee> readFile(String fileName) {
		List<Employee> list = new ArrayList<Employee>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String row = reader.readLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			while ((row = reader.readLine()) != null) {
				String[] data = row.split("\t");
				Employee e = FactoryEmployee.getEmployee(data[0], Integer.parseInt(data[1]),
						LocalDate.parse(data[2], formatter), Integer.parseInt(data[3]), data[4]);
				list.add(e);

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public void writeFile(String fileName) {
		List<List<String>> rows = Arrays.asList(Arrays.asList("A1", "24", "12/12/1967", "24000", "S"),
				Arrays.asList("A2", "34", "12/12/1957", "54000", "C"),
				Arrays.asList("A3", "44", "12/12/1977", "64000", "D"),
				Arrays.asList("A4", "24", "12/12/1987", "44000", "S"),
				Arrays.asList("A5", "54", "12/12/1997", "64000", "D"));
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			fileWriter.append("NAME");
			fileWriter.append("\t");
			fileWriter.append("AGE");
			fileWriter.append("\t");
			fileWriter.append("DOB");
			fileWriter.append("\t");
			fileWriter.append("SALARY");
			fileWriter.append("\t");
			fileWriter.append("CITY");
			fileWriter.append("\n");
			for (List<String> rowData : rows) {
				fileWriter.append(String.join("\t", rowData));
				fileWriter.append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
