package com.jakipradip.service;

import com.jakipradip.vo.VehicleVO;

public interface VehicleService {
	VehicleListVO findAll();

	VehicleListVO findByAnyField(final String anyFieldValue);

	VehicleListVO findById(final Long id);

	VehicleListVO findByActiveStatus(final boolean activeStatus);

	VehicleListVO findByType(final String type);

	VehicleListVO findByRegNum(final String regNum);

	int countByRegNum(final VehicleVO vehicleVO);

	VehicleVO createVehicle(final VehicleVO vehicleVO);

	VehicleVO updateVehicle(final VehicleVO vehicleVO);

	void deleteVehicle(final Long id);

	ScheduleListVO getScheldulesById(Long id);

	VehicleVO updateVehicleStatus(VehicleVO vehicleVO);
}
