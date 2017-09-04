package com.jakipradip.dao;

import java.util.List;

import com.jakipradip.entity.RouteEntity;
import com.jakipradip.entity.ScheduleEntity;

public interface RouteDAO {
	List<RouteEntity> findAll();

	List<RouteEntity> findById(final Long id);

	List<RouteEntity> findByAnyField(final String anyFieldValue);

	RouteEntity findOneById(final Long id);

	List<RouteEntity> findByName(final String name);

	int coundByName(final String name, final Long id);

	List<RouteEntity> findBySDest(final String sDest);

	List<RouteEntity> findByEDest(final String eDest);

	RouteEntity createOrUpdateRoute(final RouteEntity routeEntity);

	void deleteRoute(final RouteEntity routeEntity);

	List<ScheduleEntity> getScheldulesById(Long id);

}
