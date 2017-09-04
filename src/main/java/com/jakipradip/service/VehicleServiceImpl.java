package com.jakipradip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jakipradip.dao.VehicleDAO;
import com.jakipradip.entity.ScheduleEntity;
import com.jakipradip.entity.VehicleEntity;
import com.jakipradip.service.mapper.ScheduleMapper;
import com.jakipradip.service.mapper.VehicleMapper;
import com.jakipradip.service.validation.VehicleValidation;
import com.jakipradip.vo.ScheduleOutputVO;
import com.jakipradip.vo.VehicleVO;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleMapper vehicleMapper;

	@Autowired
	private ScheduleMapper scheduleMapper;

	@Autowired
	private VehicleDAO vehicleDAO;

	@Autowired
	private VehicleValidation vehicleValidation;

	@Override
	public VehicleListVO findByAnyField(final String anyFieldValue) {
		String searchField = anyFieldValue.trim();
		List<VehicleEntity> listVehicleEntity = vehicleDAO.findByAnyField(searchField);
		List<VehicleVO> vehicleListVO = vehicleMapper.mapListEntityToListVO(listVehicleEntity);
		return new VehicleListVO(vehicleListVO);
	}

	@Override
	public VehicleListVO findById(final Long id) {
		List<VehicleEntity> listVehicleEntity = vehicleDAO.findById(id);
		List<VehicleVO> vehicleListVO = vehicleMapper.mapListEntityToListVO(listVehicleEntity);
		return new VehicleListVO(vehicleListVO);
	}

	@Override
	public VehicleListVO findByActiveStatus(final boolean activeStatus) {
		String searchField = activeStatus ? "ACTIVE" : "INACTIVE";
		List<VehicleEntity> listVehicleEntity = vehicleDAO.findByActiveStatus(searchField);
		List<VehicleVO> vehicleListVO = vehicleMapper.mapListEntityToListVO(listVehicleEntity);
		return new VehicleListVO(vehicleListVO);
	}

	@Override
	public VehicleListVO findByType(final String type) {
		String searchField = type.trim() + "%";
		List<VehicleEntity> listVehicleEntity = vehicleDAO.findByType(searchField);
		List<VehicleVO> vehicleListVO = vehicleMapper.mapListEntityToListVO(listVehicleEntity);
		return new VehicleListVO(vehicleListVO);
	}

	@Override
	public VehicleListVO findByRegNum(final String regNum) {
		String searchField = regNum.trim() + "%";
		List<VehicleEntity> listVehicleEntity = vehicleDAO.findByRegNum(searchField);
		List<VehicleVO> vehicleListVO = vehicleMapper.mapListEntityToListVO(listVehicleEntity);
		return new VehicleListVO(vehicleListVO);
	}

	@Override
	public VehicleVO createVehicle(final VehicleVO vehicleVO) {
		vehicleValidation.validateToCreateVehicle(vehicleVO);
		VehicleEntity vehicleEntity = vehicleMapper.mapVOToEntity(new VehicleEntity(), vehicleVO);
		vehicleEntity = vehicleDAO.createOrUpdateVehicle(vehicleEntity);
		vehicleVO.setId(vehicleEntity.getId());
		return vehicleVO;
	}

	@Override
	public VehicleVO updateVehicle(final VehicleVO vehicleVO) {
		vehicleValidation.validateToUpdateVehicle(vehicleVO);
		VehicleEntity vehicleEntity = vehicleDAO.findOneById(vehicleVO.getId());
		vehicleEntity = vehicleMapper.mapVOToEntity(vehicleEntity, vehicleVO);
		vehicleEntity = vehicleDAO.createOrUpdateVehicle(vehicleEntity);
		return vehicleVO;
	}

	@Override
	public void deleteVehicle(final Long id) {
		vehicleDAO.deleteVehicle(vehicleDAO.findOneById(id));
	}

	@Override
	public VehicleListVO findAll() {
		List<VehicleEntity> listVehicleEntity = vehicleDAO.findAll();
		List<VehicleVO> vehicleListVO = vehicleMapper.mapListEntityToListVO(listVehicleEntity);
		return new VehicleListVO(vehicleListVO);
	}

	@Override
	public int countByRegNum(final VehicleVO vehicleVO) {
		if (vehicleVO.getId() == null) {
			return vehicleDAO.countByRegNum(vehicleVO.getRegNum().trim(), new Long(0));
		} else {
			return vehicleDAO.countByRegNum(vehicleVO.getRegNum().trim(), vehicleVO.getId());
		}
	}

	@Override
	public ScheduleListVO getScheldulesById(Long id) {
		List<ScheduleEntity> listScheduleEntity = vehicleDAO.getScheldulesById(id);
		List<ScheduleOutputVO> scheduleListVO = scheduleMapper.mapListEntityToListVO(listScheduleEntity);
		return new ScheduleListVO(scheduleListVO);
	}

	@Override
	public VehicleVO updateVehicleStatus(final VehicleVO vehicleVO) {
		VehicleEntity vehicleEntity = vehicleDAO.updateVehicleStatus(vehicleVO.getId());
		return vehicleMapper.mapEntityToVO(vehicleEntity);
	}

}
