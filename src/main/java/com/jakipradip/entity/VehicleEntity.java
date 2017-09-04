package com.jakipradip.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jakipradip.dao.QueryConstant;
import com.jakipradip.myEnum.ActiveStatus;
import com.jakipradip.myEnum.VehicleMake;
import com.jakipradip.myEnum.VehicleType;

@Entity
@Table(name = "VEHICLE")
@NamedQueries({ @NamedQuery(name = QueryConstant.FIND_VEHICLE_ALL, query = "SELECT c FROM VehicleEntity c"),
		@NamedQuery(name = QueryConstant.FIND_VEHICLE_BY_ACTIVESTATUS, query = "SELECT c FROM VehicleEntity c WHERE UPPER(c.activeStatus) LIKE UPPER(:activeStatus)"),
		@NamedQuery(name = QueryConstant.FIND_VEHICLE_BY_ID, query = "SELECT c FROM VehicleEntity c WHERE c.id BETWEEN :min AND :max"),
		@NamedQuery(name = QueryConstant.FIND_VEHICLE_BY_REGNUM, query = "SELECT c FROM VehicleEntity c WHERE UPPER(c.regNum) LIKE UPPER(:regNum)"),
		@NamedQuery(name = QueryConstant.COUNT_VEHICLE_BY_REGNUM, query = "SELECT c FROM VehicleEntity c WHERE UPPER(c.regNum) LIKE UPPER(:regNum) AND c.id != :id "),
		@NamedQuery(name = QueryConstant.FIND_VEHICLE_BY_TYPE, query = "SELECT c FROM VehicleEntity c WHERE UPPER(c.type) LIKE UPPER(:type)"),
		@NamedQuery(name = QueryConstant.FIND_VEHICLE_BY_ANYFIELD, query = "SELECT c FROM VehicleEntity c WHERE "
				+ "UPPER(c.activeStatus) LIKE UPPER(:anyField)"
				+ "OR UPPER(c.regNum) LIKE UPPER(:anyField) OR UPPER(c.type) LIKE UPPER(:anyField) OR c.id BETWEEN :idMin AND :idMax") })
public class VehicleEntity {

	@Id
	@SequenceGenerator(name = "vehIdGen", sequenceName = "VEHICLE_ID", allocationSize = 1)
	@GeneratedValue(generator = "vehIdGen")
	@Column(name = "ID")
	private Long id;
	@Column(name = "VIN")
	private String vin;
	@Column(name = "REG_NUM")
	private String regNum;
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	private VehicleType type;
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private ActiveStatus activeStatus;
	@Enumerated(EnumType.STRING)
	@Column(name = "MAKE")
	private VehicleMake make;
	@Column(name = "YEAR")
	private Long year;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
	private List<ScheduleEntity> seheduleList;

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

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public ActiveStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public VehicleMake getMake() {
		return make;
	}

	public void setMake(VehicleMake make) {
		this.make = make;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public List<ScheduleEntity> getSeheduleList() {
		return seheduleList;
	}

	public void setSeheduleList(List<ScheduleEntity> seheduleList) {
		this.seheduleList = seheduleList;
	}

	@Override
	public String toString() {
		return "VehicleEntity [id=" + id + ", vin=" + vin + ", regNum=" + regNum + ", type=" + type + ", activeStatus="
				+ activeStatus + ", make=" + make + ", year=" + year + "]";
	}

}
