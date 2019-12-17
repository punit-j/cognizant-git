package com.test.assignment_12dec;

import java.util.List;

public interface FileOperations {
public List<Employee> readFile(String fileName);
public void writeFile(String fileName);
}
