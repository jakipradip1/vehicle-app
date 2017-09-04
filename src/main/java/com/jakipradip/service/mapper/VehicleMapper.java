package com.jakipradip.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jakipradip.entity.VehicleEntity;
import com.jakipradip.myEnum.ActiveStatus;
import com.jakipradip.myEnum.VehicleMake;
import com.jakipradip.myEnum.VehicleType;
import com.jakipradip.vo.VehicleVO;

@Component
public class VehicleMapper {
	public VehicleVO mapEntityToVO(final VehicleEntity vehicleEntity) {
		VehicleVO vehicleVO = new VehicleVO();

		vehicleVO.setId(vehicleEntity.getId());
		vehicleVO.setVin(vehicleEntity.getVin());
		vehicleVO.setRegNum(vehicleEntity.getRegNum());
		vehicleVO.setType(vehicleEntity.getType().toString());

		boolean activeStatus = ((vehicleEntity.getActiveStatus().toString().equals("ACTIVE") ? true : false));
		vehicleVO.setActiveStatus(activeStatus);
		vehicleVO.setMake(vehicleEntity.getMake().toString());
		vehicleVO.setYear(vehicleEntity.getYear());

		return vehicleVO;
	}

	public VehicleEntity mapVOToEntity(final VehicleEntity vehicleEntity, final VehicleVO vehicleVO) {
		vehicleEntity.setId(vehicleVO.getId());
		vehicleEntity.setVin(vehicleVO.getVin());
		vehicleEntity.setRegNum(vehicleVO.getRegNum().trim());
		vehicleEntity.setType(VehicleType.valueOf(vehicleVO.getType().trim()));
		System.out.println(vehicleVO.isActiveStatus());
		String activeStatus = ((vehicleVO.isActiveStatus() ? "ACTIVE" : "INACTIVE"));
		System.out.println(activeStatus);
		vehicleEntity.setActiveStatus(ActiveStatus.valueOf(activeStatus));
		vehicleEntity.setMake(VehicleMake.valueOf(vehicleVO.getMake()));
		vehicleEntity.setYear(vehicleVO.getYear());
		return vehicleEntity;
	}

	public List<VehicleVO> mapListEntityToListVO(final List<VehicleEntity> listVehicleEntity) {
		List<VehicleVO> listVehicleVO = new ArrayList<VehicleVO>();
		for (VehicleEntity vehicleEntity : listVehicleEntity) {
			listVehicleVO.add(this.mapEntityToVO(vehicleEntity));
		}
		return listVehicleVO;
	}
}
