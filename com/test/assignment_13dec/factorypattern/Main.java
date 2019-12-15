package com.test.factorypattern;

/**
 * contains main method to call read and write operation
 * @author Punit
 *
 */
public class Main {

	public static void main(String[] args) {
		FileOperations fe = FactoryEmployee.getFileOperations();
		fe.writeFile("A.tsv");
		System.out.println(fe.readFile("A.tsv"));
	}

}
