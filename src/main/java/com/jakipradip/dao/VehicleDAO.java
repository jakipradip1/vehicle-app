package com.jakipradip.dao;

import java.util.List;

import com.jakipradip.entity.ScheduleEntity;
import com.jakipradip.entity.VehicleEntity;

public interface VehicleDAO {
	List<VehicleEntity> findAll();

	List<VehicleEntity> findByAnyField(final String anyFieldValue);

	List<VehicleEntity> findById(final Long id);

	VehicleEntity findOneById(final Long id);

	List<VehicleEntity> findByActiveStatus(final String activeStatus);

	List<VehicleEntity> findByType(final String type);

	List<VehicleEntity> findByRegNum(final String regNum);

	int countByRegNum(final String regNum, final Long id);

	VehicleEntity createOrUpdateVehicle(final VehicleEntity vehicleEntity);

	void deleteVehicle(final VehicleEntity vehicleEntity);

	List<ScheduleEntity> getScheldulesById(Long id);

	VehicleEntity updateVehicleStatus(Long id);
}
