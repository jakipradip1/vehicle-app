package com.jakipradip.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jakipradip.entity.RouteEntity;
import com.jakipradip.entity.ScheduleEntity;
import com.jakipradip.entity.VehicleEntity;
import com.jakipradip.vo.ScheduleInputVO;
import com.jakipradip.vo.ScheduleOutputVO;

@Component
public class ScheduleMapper {

	@Autowired
	private RouteMapper routeMapper;

	@Autowired
	private VehicleMapper vehicleMapper;

	public ScheduleEntity mapVOToEntity(ScheduleEntity scheduleEntity, ScheduleInputVO scheduleInputVO) {
		scheduleEntity.setPk(scheduleInputVO.getPk());
		scheduleEntity.setSecheduleId(scheduleInputVO.getSecheduleId());
		scheduleEntity.setSchDate(scheduleInputVO.getSchDate());
		scheduleEntity.setStartTime(scheduleInputVO.getStartTime());
		scheduleEntity.setEndTime(scheduleInputVO.getEndTime());

		RouteEntity routeEntity = new RouteEntity();
		routeEntity.setId(scheduleInputVO.getRouteId());
		scheduleEntity.setRoute(routeEntity);

		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setId(scheduleInputVO.getVehicleId());
		scheduleEntity.setVehicle(vehicleEntity);
		return scheduleEntity;
	}

	public ScheduleOutputVO mapEntityToVO(ScheduleEntity scheduleEntity) {
		ScheduleOutputVO scheduleOutputVO = new ScheduleOutputVO();
		scheduleOutputVO.setPk(scheduleEntity.getPk());
		scheduleOutputVO.setSecheduleId(scheduleEntity.getSecheduleId());
		scheduleOutputVO.setSchDate(scheduleEntity.getSchDate());
		scheduleOutputVO.setStartTime(scheduleEntity.getStartTime());
		scheduleOutputVO.setEndTime(scheduleEntity.getEndTime());

		scheduleOutputVO.setRoute(routeMapper.mapEntityToVO(scheduleEntity.getRoute()));
		scheduleOutputVO.setVehicle(vehicleMapper.mapEntityToVO(scheduleEntity.getVehicle()));
		return scheduleOutputVO;
	}

	public List<ScheduleOutputVO> mapListEntityToListVO(List<ScheduleEntity> listScheduleEntity) {
		List<ScheduleOutputVO> listScheduleVO = new ArrayList<ScheduleOutputVO>();
		for (ScheduleEntity scheduleEntity : listScheduleEntity) {
			listScheduleVO.add(this.mapEntityToVO(scheduleEntity));
		}
		return listScheduleVO;
	}
}
