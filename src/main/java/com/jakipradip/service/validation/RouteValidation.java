package com.jakipradip.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jakipradip.service.RouteService;
import com.jakipradip.service.exception.DuplicateException;
import com.jakipradip.service.exception.InvalidDataException;
import com.jakipradip.vo.RouteVO;

@Component
public class RouteValidation {
	@Autowired
	private RouteService routeService;

	public void validateToCreateRoute(final RouteVO routeVO) {
		validateDupName(routeVO);
		validateNullField(routeVO);
	}

	public void validateToUpdateRoute(final RouteVO routeVO) {
		validateDupName(routeVO);
		validateNullId(routeVO);
		validateNullField(routeVO);
	}

	private void validateDupName(final RouteVO routeVO) {
		if (routeService.countByName(routeVO) > 0) {
			throw new DuplicateException("The route with same sDest, eDest and sTime exists");
		}
	}

	private void validateNullId(final RouteVO routeVO) {
		if (routeVO.getId() == null) {
			throw new InvalidDataException("Id is missing.");
		}
	}

	private void validateNullField(final RouteVO routeVO) {
		if (routeVO.getsDest() == null || routeVO.getsDest().trim().equals("")) {
			throw new InvalidDataException("sDest is missing.");
		}
		if (routeVO.geteDest() == null || routeVO.geteDest().trim().equals("")) {
			throw new InvalidDataException("eDest is missing.");
		}
		if (routeVO.geteTime() == null || routeVO.geteTime().trim().equals("")) {
			throw new InvalidDataException("eTime is missing.");
		}
		if (routeVO.getsTime() == null || routeVO.getsTime().trim().equals("")) {
			throw new InvalidDataException("sTime is missing.");
		}
	}
}
