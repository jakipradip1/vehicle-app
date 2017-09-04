package com.jakipradip.service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.jakipradip.vo.RouteVO;

@XmlRootElement
public class RouteListVO {
	private List<RouteVO> listRouteVO;

	public RouteListVO() {
	}

	public RouteListVO(List<RouteVO> listRouteVO) {
		this.listRouteVO = listRouteVO;
	}

	public List<RouteVO> getListRouteVO() {
		return listRouteVO;
	}

	public void setListRouteVO(List<RouteVO> listRouteVO) {
		this.listRouteVO = listRouteVO;
	}

}
