package com.jakipradip.service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.jakipradip.vo.ScheduleOutputVO;

@XmlRootElement
public class ScheduleListVO {

	private List<ScheduleOutputVO> listScheduleVO;

	public ScheduleListVO() {

	}

	public ScheduleListVO(List<ScheduleOutputVO> listScheduleVO) {
		this.listScheduleVO = listScheduleVO;
	}

	public List<ScheduleOutputVO> getListScheduleVO() {
		return listScheduleVO;
	}

	public void setListScheduleVO(List<ScheduleOutputVO> listScheduleVO) {
		this.listScheduleVO = listScheduleVO;
	}

}
