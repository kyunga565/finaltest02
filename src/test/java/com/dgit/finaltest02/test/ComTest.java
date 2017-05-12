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
	public void testInsert(){
		Employee dObj = new Employee(9, "경", 1, 100, 0, 1, new Date()); 
		cs.insertEmployee(dObj);
		System.out.println(dObj);
	}
//	@Test
	public void testDelete() {
		cs.deleteEmployee(8+"");
		List<Employee> list = cs.selectEmployee();
		System.out.println(list);
		
	}
//	@Test
	public void testUpdate(){
		Employee dObj = new Employee(9, "경아테스트", 2, 200000, 1, 3, new Date());
		cs.updateEmployee(dObj);
		System.out.println(dObj);
	}
//	@Test
	public void testSelect() {
	//	int select = cs.getEno();
		List<Employee> select = cs.selectEmployee();
		Assert.assertNotNull(select);
		System.out.println(select);
	}

	@Test
	public void testSelectOne() {
		Title select = cs.selectTitle(1);
		Assert.assertNotNull(select);
		System.out.println(select);
	}


}
