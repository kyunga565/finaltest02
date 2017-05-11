package com.dgit.finaltest02.dto;

public class Title {
	private int tcode;
	private String tname;

	public Title() {
	}

	public Title(int tcode) {
		this.tcode = tcode;
	}

	public int getTcode() {
		return tcode;
	}

	public void setTcode(int tcode) {
		this.tcode = tcode;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Title(int tcode, String tname) {
		this.tcode = tcode;
		this.tname = tname;
	}

	@Override
	public String toString() {
		return String.format("%s", tname);
	}

	public String[] toArray() {
		return new String[] { tcode + "", tname };//
	}

	@Override
	public boolean equals(Object obj) {
		Title t = (Title) obj;
		if (tcode == t.tcode) {
			return true;
		} else {
			return false;
		}
	}
}
