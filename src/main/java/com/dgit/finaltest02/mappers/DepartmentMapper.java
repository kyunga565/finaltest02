package com.dgit.finaltest02.mappers;

import java.util.List;

import com.dgit.finaltest02.dto.Department;


public interface DepartmentMapper {
	List<Department> selectPart(); 
	List<Department> selectAllPart();
	int getDno();
	void insertItem(Department dObj);
	void updateItem(Department dObj);
	void deleteItem(String no);
	Department getDcode(int no);
}
