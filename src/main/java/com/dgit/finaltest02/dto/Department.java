package com.dgit.finaltest02.dto;

public class Department {
	private int dcode;
	private String dname;
	private int floor;

	public Department() {
	}
	
	public Department(int dcode) {
		this.dcode = dcode;
	}


	public Department(String dname) {
		this.dname = dname;
	}

	public int getDcode() {
		return dcode;
	}

	public void setDcode(int dcode) {
		this.dcode = dcode;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Department(int dcode, String dname, int floor) {
		this.dcode = dcode;
		this.dname = dname;
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("%s(%s층)", dname, floor);
	}

	
	public String[] toArray() {
		return new String[] { dcode + "", dname, floor + "" };
	}

	@Override
	public boolean equals(Object obj) {
		return dcode == ((Department) obj).dcode ? true : false;
	}
}
