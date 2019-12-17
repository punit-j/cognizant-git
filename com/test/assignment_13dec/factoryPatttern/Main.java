package com.test.assignment_12dec;

public class Main {

	public static void main(String[] args) {
		FileOperations csv = FactoryEmployee.getCsvOperations();
		csv.writeFile("A.csv");
		System.out.println(csv.readFile("A.csv"));
		FileOperations tsv = FactoryEmployee.getTsvOperations();
		tsv.writeFile("A.tsv");
		System.out.println(tsv.readFile("A.tsv"));
	}

}
