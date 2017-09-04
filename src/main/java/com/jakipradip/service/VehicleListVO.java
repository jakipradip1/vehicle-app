package com.jakipradip.service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.jakipradip.vo.VehicleVO;

@XmlRootElement
public class VehicleListVO {
	private List<VehicleVO> listVehicleVO;

	public VehicleListVO() {
	}

	public VehicleListVO(List<VehicleVO> listVehicleVO) {
		super();
		this.listVehicleVO = listVehicleVO;
	}

	public List<VehicleVO> getListVehicleVO() {
		return listVehicleVO;
	}

	public void setListVehicleVO(List<VehicleVO> listVehicleVO) {
		this.listVehicleVO = listVehicleVO;
	}

}
