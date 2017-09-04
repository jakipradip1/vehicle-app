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
import com.jakipradip.myEnum.Destination;

@Entity
@Table(name = "ROUTE")
@NamedQueries({ @NamedQuery(name = QueryConstant.FIND_ROUTE_ALL, query = "SELECT c FROM RouteEntity c"),
		@NamedQuery(name = QueryConstant.FIND_ROUTE_BY_ID, query = "SELECT c FROM RouteEntity c WHERE c.id BETWEEN :min AND :max"),
		@NamedQuery(name = QueryConstant.COUNT_ROUTE_BY_NAME, query = "SELECT c FROM RouteEntity c WHERE c.id != :id AND UPPER(c.name) LIKE UPPER(:name)"),
		@NamedQuery(name = QueryConstant.FIND_ROUTE_BY_NAME, query = "SELECT c FROM RouteEntity c WHERE UPPER(c.name) LIKE UPPER(:name)"),
		@NamedQuery(name = QueryConstant.FIND_ROUTE_BY_S_DEST, query = "SELECT c FROM RouteEntity c WHERE UPPER(c.sDest) LIKE UPPER(:sDest)"),
		@NamedQuery(name = QueryConstant.FIND_ROUTE_BY_E_DEST, query = "SELECT c FROM RouteEntity c WHERE UPPER(c.eDest) LIKE UPPER(:eDest)"),
		@NamedQuery(name = QueryConstant.FIND_ROUTE_BY_ANYFIELD, query = "SELECT c FROM RouteEntity c WHERE"
				+ " UPPER(c.sDest) LIKE UPPER(:anyField) OR UPPER(c.eDest) LIKE UPPER(:anyField)"
				+ "OR UPPER(c.sTime) LIKE UPPER(:anyField) OR UPPER(c.eTime) LIKE UPPER(:anyField) OR c.id BETWEEN :idMin AND :idMax") })
public class RouteEntity {

	@Id
	@SequenceGenerator(name = "rouIdGen", sequenceName = "ROUTE_ID", allocationSize = 1)
	@GeneratedValue(generator = "rouIdGen")
	@Column(name = "ID")
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "START_DESTINATION")
	private Destination sDest;
	@Enumerated(EnumType.STRING)
	@Column(name = "END_DESTINATION")
	private Destination eDest;
	@Column(name = "START_TIME")
	private String sTime;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ETA")
	private String eTime;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
	private List<ScheduleEntity> seheduleList;

	public List<ScheduleEntity> getSeheduleList() {
		return seheduleList;
	}

	public void setSeheduleList(List<ScheduleEntity> seheduleList) {
		this.seheduleList = seheduleList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Destination getsDest() {
		return sDest;
	}

	public void setsDest(Destination sDest) {
		this.sDest = sDest;
	}

	public Destination geteDest() {
		return eDest;
	}

	public void seteDest(Destination eDest) {
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
		return "RouteEntity [id=" + id + ", sDest=" + sDest + ", eDest=" + eDest + ", sTime=" + sTime + ", name=" + name
				+ ", eTime=" + eTime + "]";
	}
}
