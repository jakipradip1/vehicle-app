package com.jakipradip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jakipradip.dao.RouteDAO;
import com.jakipradip.entity.RouteEntity;
import com.jakipradip.entity.ScheduleEntity;
import com.jakipradip.service.mapper.RouteMapper;
import com.jakipradip.service.mapper.ScheduleMapper;
import com.jakipradip.service.validation.RouteValidation;
import com.jakipradip.vo.RouteVO;
import com.jakipradip.vo.ScheduleOutputVO;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteMapper routeMapper;

	@Autowired
	private ScheduleMapper scheduleMapper;

	@Autowired
	private RouteDAO routeDAO;

	@Autowired
	private RouteValidation routeValidation;

	@Override
	public RouteListVO findById(final Long id) {
		List<RouteEntity> listRouteEntity = routeDAO.findById(id);
		List<RouteVO> routeListVO = routeMapper.mapListEntityToListVO(listRouteEntity);
		return new RouteListVO(routeListVO);
	}

	@Override
	public RouteListVO findByAnyField(final String anyFieldValue) {
		String searchField = anyFieldValue.trim();
		List<RouteEntity> listRouteEntity = routeDAO.findByAnyField(searchField);
		List<RouteVO> routeListVO = routeMapper.mapListEntityToListVO(listRouteEntity);
		return new RouteListVO(routeListVO);
	}

	@Override
	public RouteListVO findByName(final String name) {
		String searchField = name.trim() + "%";
		List<RouteEntity> listRouteEntity = routeDAO.findByName(searchField);
		List<RouteVO> routeListVO = routeMapper.mapListEntityToListVO(listRouteEntity);
		return new RouteListVO(routeListVO);
	}

	@Override
	public RouteListVO findBySDest(final String sDest) {
		String searchField = sDest.trim() + "%";
		List<RouteEntity> listRouteEntity = routeDAO.findBySDest(searchField);
		List<RouteVO> routeListVO = routeMapper.mapListEntityToListVO(listRouteEntity);
		return new RouteListVO(routeListVO);
	}

	@Override
	public RouteListVO findByEDest(final String eDest) {
		String searchField = eDest.trim() + "%";
		List<RouteEntity> listRouteEntity = routeDAO.findByEDest(searchField);
		List<RouteVO> routeListVO = routeMapper.mapListEntityToListVO(listRouteEntity);
		return new RouteListVO(routeListVO);
	}

	@Override
	public RouteVO createRoute(final RouteVO routeVO) {
		routeValidation.validateToCreateRoute(routeVO);
		RouteEntity routeEntity = routeMapper.mapVOToEntity(new RouteEntity(), routeVO);
		routeEntity = routeDAO.createOrUpdateRoute(routeEntity);
		routeVO.setId(routeEntity.getId());
		routeVO.setName(routeEntity.getName());
		return routeVO;
	}

	@Override
	public RouteVO updateRoute(final RouteVO routeVO) {
		routeValidation.validateToUpdateRoute(routeVO);
		RouteEntity routeEntity = routeDAO.findOneById(routeVO.getId());
		routeEntity = routeMapper.mapVOToEntity(routeEntity, routeVO);
		routeEntity = routeDAO.createOrUpdateRoute(routeEntity);
		routeVO.setName(routeEntity.getName());
		return routeVO;
	}

	@Override
	public void deleteRoute(final Long id) {
		routeDAO.deleteRoute(routeDAO.findOneById(id));
	}

	@Override
	public RouteListVO findAll() {
		List<RouteEntity> listRouteEntity = routeDAO.findAll();
		List<RouteVO> routeListVO = routeMapper.mapListEntityToListVO(listRouteEntity);
		return new RouteListVO(routeListVO);
	}

	@Override
	public int countByName(final RouteVO routeVO) {
		String name = routeVO.getsDest().trim() + "_" + routeVO.geteDest().trim() + "_" + routeVO.getsTime().trim();

		if (routeVO.getId() == null) {
			return routeDAO.coundByName(name, new Long(0));
		} else {
			return routeDAO.coundByName(name, routeVO.getId());
		}
	}

	@Override
	public ScheduleListVO getScheldulesById(Long id) {
		List<ScheduleEntity> listScheduleEntity = routeDAO.getScheldulesById(id);
		List<ScheduleOutputVO> scheduleListVO = scheduleMapper.mapListEntityToListVO(listScheduleEntity);
		return new ScheduleListVO(scheduleListVO);
	}
}
