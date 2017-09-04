package com.jakipradip.service;

import com.jakipradip.vo.RouteVO;

public interface RouteService {
	RouteListVO findAll();

	RouteListVO findById(final Long id);

	RouteListVO findByAnyField(final String anyFieldValue);

	RouteListVO findByName(final String name);

	int countByName(final RouteVO routeVO);

	RouteListVO findBySDest(final String sDest);

	RouteListVO findByEDest(final String eDest);

	RouteVO createRoute(final RouteVO routeVO);

	RouteVO updateRoute(final RouteVO routeVO);

	void deleteRoute(final Long id);

	ScheduleListVO getScheldulesById(Long id);
}
