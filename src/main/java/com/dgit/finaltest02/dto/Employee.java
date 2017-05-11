package com.dgit.finaltest02.dto;

import java.util.Date;

public class Employee {//"번호", "사원명", "직책", "급여", "성별", "부서","입사일"
	private int eno;
	private String ename;
	private int tcode;
	private int salary;
	private int gender;
	private int dcode;
	private Date joindate;


	public Employee(int eno, String ename, int tcode, int salary, int gender, int dcode, Date joindate) {
		this.eno = eno;
		this.ename = ename;
		this.tcode = tcode;
		this.salary = salary;
		this.gender = gender;
		this.dcode = dcode;
		this.joindate = joindate;
	}


	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public int getTcode() {
		return tcode;
	}


	public void setTcode(int tcode) {
		this.tcode = tcode;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public int getDcode() {
		return dcode;
	}


	public void setDcode(int dcode) {
		this.dcode = dcode;
	}


	public Date getJoindate() {
		return joindate;
	}


	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}


	public Employee() {
	}


	@Override
	public String toString() {
		return String.format("Employee [eno=%s, tcode=%s, ename=%s, salary=%s, gender=%s, joindate=%s, dcode=%s]", eno,
				tcode, ename, salary, gender, joindate, dcode);
	}

	public String[] toArray() {
		return new String[] { 
				eno + ""
				, ename
				, tcode + ""
				, String.format("%,d", salary)
				, gender + ""
				, dcode + ""
				, joindate + ""};
	}
	//"번호", "사원명", "직책", "급여", "성별", "부서","입사일"
	
	
	
	@Override
	 public boolean equals(Object obj) {
	 Employee e = (Employee) obj;
	 return eno==e.eno?true:false;
	 }
}
