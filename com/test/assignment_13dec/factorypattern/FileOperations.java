package com.test.factorypattern;

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

/**
 * Does read and write operations for .csv and .tsv file
 * 
 * @author Punit
 *
 */
public class FileOperations {
	public List<com.test.factorypattern.Employee> readFile(String fileName) { // reads
																				// the
																				// data
																				// from
																				// file
																				// and
																				// store
																				// it
																				// in
																				// ArrayList
		List<com.test.factorypattern.Employee> list = new ArrayList<com.test.factorypattern.Employee>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String row = reader.readLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			while ((row = reader.readLine()) != null) {
				if (fileName.substring(fileName.length() - 4).equalsIgnoreCase(".csv")) {
					String[] data = row.split(",");
					com.test.factorypattern.Employee e = FactoryEmployee.getEmployee(data[0], Integer.parseInt(data[1]),
							LocalDate.parse(data[2], formatter), Integer.parseInt(data[3]), data[4]);
					list.add(e);
				} else if (fileName.substring(fileName.length() - 4).equalsIgnoreCase(".tsv")) {
					String[] data = row.split("\t");
					com.test.factorypattern.Employee e = FactoryEmployee.getEmployee(data[0], Integer.parseInt(data[1]),
							LocalDate.parse(data[2], formatter), Integer.parseInt(data[3]), data[4]);
					list.add(e);
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	public void writeFile(String fileName) { // writes data to file
		List<List<String>> rows = Arrays.asList(Arrays.asList("A1", "24", "12/12/1967", "24000", "S"),
				Arrays.asList("A2", "34", "12/12/1957", "54000", "C"),
				Arrays.asList("A3", "44", "12/12/1977", "64000", "D"),
				Arrays.asList("A4", "24", "12/12/1987", "44000", "S"),
				Arrays.asList("A5", "54", "12/12/1997", "64000", "D"));
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			if (fileName.substring(fileName.length() - 4).equalsIgnoreCase(".csv")) {
				fileWriter.append("NAME");
				fileWriter.append(",");
				fileWriter.append("AGE");
				fileWriter.append(",");
				fileWriter.append("DOB");
				fileWriter.append(",");
				fileWriter.append("SALARY");
				fileWriter.append(",");
				fileWriter.append("CITY");
				fileWriter.append("\n");
				for (List<String> rowData : rows) {
					fileWriter.append(String.join(",", rowData));
					fileWriter.append("\n");
				}
			} else if (fileName.substring(fileName.length() - 4).equalsIgnoreCase(".tsv")) {
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
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
