package com.dgit.finaltest02.dto;

import java.util.Date;

public class Employee22 {//"번호", "사원명", "직책", "급여", "성별", "부서","입사일"
	private int eno;
	private String ename;
	private Title tcode;
	private int salary;
	private int gender;
	private Department dcode;
	private Date joindate;

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
	public Title getTcode() {
		return tcode;
	}
	public void setTcode(Title tcode) {
		this.tcode = tcode;
	}
	
	public void setTname(String tname) {
		if(this.tcode == null)
			this.tcode = new Title();
		this.tcode.setTname(tname);
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

	public Department getDcode() {
		return dcode;
	}

	public void setDcode(Department dcode) {
		this.dcode = dcode;
	}

	public void setDname(String dname) {
		if(this.dcode == null)
			this.dcode = new Department();
		this.dcode.setDname(dname);
	}
	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public Employee22(int eno, String ename, Title tcode, int salary, int gender, Department dcode, Date joindate) {
		this.eno = eno;
		this.ename = ename;
		this.tcode = tcode;
		this.salary = salary;
		this.gender = gender;
		this.dcode = dcode;
		this.joindate = joindate;
	}


	public Employee22() {
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
				, tcode.getTname()
				, String.format("%,d", salary)
				, gender + ""
				, dcode.getDname()
				, joindate + ""};
	}
	//"번호", "사원명", "직책", "급여", "성별", "부서","입사일"
	
	@Override
	 public boolean equals(Object obj) {
	 Employee22 e = (Employee22) obj;
	 return eno==e.eno?true:false;
	 }
}
