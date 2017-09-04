package com.jakipradip.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jakipradip.entity.RouteEntity;
import com.jakipradip.myEnum.Destination;
import com.jakipradip.vo.RouteVO;

@Component
public class RouteMapper {
	public RouteVO mapEntityToVO(final RouteEntity routeEntity) {
		System.out.println(routeEntity);
		RouteVO routeVO = new RouteVO();

		routeVO.setId(routeEntity.getId());
		routeVO.setName(routeEntity.getName());
		routeVO.setsDest(routeEntity.getsDest().toString());
		routeVO.seteDest(routeEntity.geteDest().toString());
		routeVO.setsTime(routeEntity.getsTime());
		routeVO.seteTime(routeEntity.geteTime());

		return routeVO;
	}

	public RouteEntity mapVOToEntity(final RouteEntity routeEntity, final RouteVO routeVO) {
		routeEntity.setsDest(Destination.valueOf(routeVO.getsDest().trim()));
		routeEntity.seteDest(Destination.valueOf(routeVO.geteDest().trim()));
		routeEntity.setsTime(routeVO.getsTime().trim());
		String routeName = "RT_" + routeVO.getsDest().trim() + "_" + routeVO.geteDest().trim() + "_"
				+ routeVO.getsTime().trim();
		routeEntity.setName(routeName);
		routeEntity.seteTime(routeVO.geteTime().trim());

		return routeEntity;
	}

	public List<RouteVO> mapListEntityToListVO(List<RouteEntity> listRouteEntity) {
		List<RouteVO> listRouteVO = new ArrayList<RouteVO>();
		for (RouteEntity routeEntity : listRouteEntity) {
			listRouteVO.add(this.mapEntityToVO(routeEntity));
		}
		return listRouteVO;
	}
}
