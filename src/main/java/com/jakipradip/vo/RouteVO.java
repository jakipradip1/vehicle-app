package com.jakipradip.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RouteVO {
	private Long id;
	private String sDest;
	private String eDest;
	private String sTime;
	private String name;
	private String eTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getsDest() {
		return sDest;
	}

	public void setsDest(String sDest) {
		this.sDest = sDest;
	}

	public String geteDest() {
		return eDest;
	}

	public void seteDest(String eDest) {
		this.eDest = eDest;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	@Override
	public String toString() {
		return "RouteVO [id=" + id + ", sDest=" + sDest + ", eDest=" + eDest + ", sTime=" + sTime + ", name=" + name
				+ ", eTime=" + eTime + "]";
	}

}
