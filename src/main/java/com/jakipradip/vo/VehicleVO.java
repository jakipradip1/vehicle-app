package com.jakipradip.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehicleVO {
	private Long id;
	private String vin;
	private String regNum;
	private String type;
	private boolean activeStatus;
	private String make;
	private Long year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "VehicleVO [id=" + id + ", vin=" + vin + ", regNum=" + regNum + ", type=" + type + ", activeStatus="
				+ activeStatus + ", make=" + make + ", year=" + year + "]";
	}
}
