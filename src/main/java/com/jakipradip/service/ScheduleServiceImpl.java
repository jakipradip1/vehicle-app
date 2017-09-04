package com.jakipradip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jakipradip.dao.RouteDAO;
import com.jakipradip.dao.ScheduleDAO;
import com.jakipradip.dao.VehicleDAO;
import com.jakipradip.entity.ScheduleEntity;
import com.jakipradip.service.mapper.ScheduleMapper;
import com.jakipradip.vo.ScheduleInputVO;
import com.jakipradip.vo.ScheduleOutputVO;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDAO scheduleDAO;

	@Autowired
	private RouteDAO routeDAO;

	@Autowired
	private VehicleDAO vehicleDAO;

	@Autowired
	private ScheduleMapper scheduleMapper;

	@Override
	public List<ScheduleOutputVO> findLastTen() {
		List<ScheduleEntity> scheduleEntityList = scheduleDAO.findLastTen();
		List<ScheduleOutputVO> scheduleOutputVOList = scheduleMapper.mapListEntityToListVO(scheduleEntityList);
		return scheduleOutputVOList;
	}

	@Override
	public List<ScheduleOutputVO> findById(Long id) {
		List<ScheduleEntity> scheduleEntityList = scheduleDAO.findById(id);
		List<ScheduleOutputVO> scheduleOutputVOList = scheduleMapper.mapListEntityToListVO(scheduleEntityList);
		return scheduleOutputVOList;
	}

	@Override
	public ScheduleOutputVO updateSchedule(ScheduleInputVO scheduleInputVO) {
		ScheduleEntity scheduleEntity = scheduleDAO.findOneById(scheduleInputVO.getPk());
		scheduleEntity = scheduleMapper.mapVOToEntity(scheduleEntity, scheduleInputVO);
		scheduleEntity.setRoute(routeDAO.findOneById(scheduleEntity.getRoute().getId()));
		scheduleEntity.setVehicle(vehicleDAO.findOneById(scheduleEntity.getVehicle().getId()));
		scheduleDAO.updateSchedule(scheduleEntity);
		return scheduleMapper.mapEntityToVO(scheduleEntity);
	}

	@Override
	public ScheduleOutputVO createSchedule(ScheduleInputVO scheduleInputVO) {
		ScheduleEntity scheduleEntity = scheduleMapper.mapVOToEntity(new ScheduleEntity(), scheduleInputVO);
		scheduleEntity.setRoute(routeDAO.findOneById(scheduleEntity.getRoute().getId()));
		scheduleEntity.setVehicle(vehicleDAO.findOneById(scheduleEntity.getVehicle().getId()));
		scheduleDAO.createSchedule(scheduleEntity);
		return scheduleMapper.mapEntityToVO(scheduleEntity);
	}

	@Override
	public void deleteSchedule(Long id) {
		ScheduleEntity scheduleEntity = scheduleDAO.findOneById(id);
		scheduleDAO.deleteSchedule(scheduleEntity);
	}

}
