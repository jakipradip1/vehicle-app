package com.jakipradip.vo;

import java.sql.Date;

public class ScheduleOutputVO {
	private Long pk;
	private Long secheduleId;
	private Date schDate;
	private String startTime;
	private String endTime;
	private RouteVO route;
	private VehicleVO vehicle;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Long getSecheduleId() {
		return secheduleId;
	}

	public void setSecheduleId(Long secheduleId) {
		this.secheduleId = secheduleId;
	}

	public Date getSchDate() {
		return schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public RouteVO getRoute() {
		return route;
	}

	public void setRoute(RouteVO route) {
		this.route = route;
	}

	public VehicleVO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleVO vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "ScheduleOutputVO [pk=" + pk + ", secheduleId=" + secheduleId + ", schDate=" + schDate + ", startTime="
				+ startTime + ", endTime=" + endTime + ", route=" + route + ", vehicle=" + vehicle + "]";
	}
}
