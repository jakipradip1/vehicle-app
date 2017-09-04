package com.jakipradip.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jakipradip.service.VehicleService;
import com.jakipradip.service.exception.DuplicateException;
import com.jakipradip.service.exception.InvalidDataException;
import com.jakipradip.vo.VehicleVO;

@Component
public class VehicleValidation {
	@Autowired
	private VehicleService vService;

	public void validateToCreateVehicle(final VehicleVO vehicleVO) {
		validateDuplicateRegNum(vehicleVO);
		validateNullField(vehicleVO);
	}

	public void validateToUpdateVehicle(final VehicleVO vehicleVO) {
		validateDuplicateRegNum(vehicleVO);
		validateNullField(vehicleVO);
		validateNullId(vehicleVO);
	}

	private void validateDuplicateRegNum(final VehicleVO vehicleVO) {
		if (vService.countByRegNum(vehicleVO) > 0) {
			throw new DuplicateException("Entered Reg Num already Exists.");
		}
	}

	private void validateNullId(final VehicleVO vehicleVO) {
		if (vehicleVO.getId() == null) {
			throw new InvalidDataException("Id is missing");
		}
	}

	private void validateNullField(final VehicleVO vehicleVO) {
		if (vehicleVO.getRegNum() == null || vehicleVO.getRegNum().trim().equals("")) {
			throw new InvalidDataException("getRegNum is missing");
		}
		if (vehicleVO.getType() == null || vehicleVO.getType().trim().equals("")) {
			throw new InvalidDataException("Type is missing");
		}
	}
}
