package com.dgit.finaltest02.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dgit.finaltest02.dto.Department;
import com.dgit.finaltest02.dto.Employee;
import com.dgit.finaltest02.dto.Employee22;
import com.dgit.finaltest02.dto.Title;
import com.dgit.finaltest02.service.CompanyService;


public class ComTest {
	private static CompanyService cs;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cs = CompanyService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cs = null;
	}

//	@Test
	public void test() {
	//	int select = cs.getEno();
		List<Employee> select = cs.selectEmployee();
		Assert.assertNotNull(select);
		System.out.println(select);
		
	}

//	@Test
//	public void test2() {
//		List<Title> select = cs.selectTitle();
//		Assert.assertNotNull(select);
//		System.out.println(select);
//	}
//	@Test
	public void test3() {
		List<Department> select = cs.selectPart();
		Assert.assertNotNull(select);
		System.out.println(select);
		
	}
	@Test
	public void test4(){
		Employee dObj = new Employee(17003, "경", 1, 100, 0, 1, new Date()); 
		cs.insertEmployee(dObj);
		System.out.println(dObj);
	}
}
