package com.jakipradip.vo;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleInputVO {
	private Long pk;
	private Long secheduleId;
	private Date schDate;
	private String startTime;
	private String endTime;
	private Long routeId;
	private Long vehicleId;

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

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "ScheduleVO [pk=" + pk + ", secheduleId=" + secheduleId + ", schDate=" + schDate + ", startTime="
				+ startTime + ", endTime=" + endTime + ", routeId=" + routeId + ", vehicleId=" + vehicleId + "]";
	}
}
