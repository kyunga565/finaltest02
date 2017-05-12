package com.dgit.finaltest02.mappers;

import java.util.List;

import com.dgit.finaltest02.dto.Employee;


public interface EmployeeMapper {
	List<Employee> selectEmployee(); 
	List<Employee> selectEmployeeTitle();
	int getEno();
	void insertEmployee(Employee dObj);
	void updateEmployee(Employee dObj);
	void deleteEmployee(String no);
}
