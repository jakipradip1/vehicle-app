package com.jakipradip.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jakipradip.dao.QueryConstant;

@Entity
@Table(name = "SCHEDULE")
@NamedQueries({ @NamedQuery(name = QueryConstant.FIND_SCHEDULE_ALL, query = "SELECT c FROM ScheduleEntity c"),
		@NamedQuery(name = QueryConstant.FIND_SCHEDULE_BY_ID, query = "SELECT c FROM ScheduleEntity c WHERE c.id BETWEEN :min AND :max") })
@NamedNativeQuery(name = QueryConstant.GENERATE_SCHEDULE_ID, query = "SELECT SCHEDULE_ID.NEXTVAL FROM DUAL")
public class ScheduleEntity {
	@Id
	@SequenceGenerator(name = "sehIdGen", sequenceName = "SCHEDULE_PK", allocationSize = 1)
	@GeneratedValue(generator = "sehIdGen")
	@Column(name = "ID")
	private Long pk;
	@Column(name = "SCHEDULE_ID")
	private Long secheduleId;
	@Column(name = "SCH_DATE")
	private Date schDate;
	@Column(name = "START_TIME")
	private String startTime;
	@Column(name = "END_TIME")
	private String endTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROUTE_ID")
	private RouteEntity route;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_ID")
	private VehicleEntity vehicle;

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

	public RouteEntity getRoute() {
		return route;
	}

	public void setRoute(RouteEntity route) {
		this.route = route;
	}

	public VehicleEntity getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "ScheduleEntity [pk=" + pk + ", secheduleId=" + secheduleId + ", schDate=" + schDate + ", startTime="
				+ startTime + ", endTime=" + endTime + ", route=" + route + ", vehicle=" + vehicle + "]";
	}
}
