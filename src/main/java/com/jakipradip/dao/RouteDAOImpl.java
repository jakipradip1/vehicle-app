package com.jakipradip.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.jakipradip.entity.RouteEntity;
import com.jakipradip.entity.ScheduleEntity;

@Service
public class RouteDAOImpl implements RouteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<RouteEntity> findById(final Long id) {
		Long min = GetMinOrMax.getMin(id, 5);
		Long max = GetMinOrMax.getMax(id, 5);
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.FIND_ROUTE_BY_ID, RouteEntity.class);
		query.setParameter("min", min);
		query.setParameter("max", max);
		return query.getResultList();
	}

	@Override
	public List<RouteEntity> findByAnyField(final String anyFieldValue) {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.FIND_ROUTE_BY_ANYFIELD, RouteEntity.class);
		query.setParameter("anyField", anyFieldValue + "%");
		String regex = "[0-9]+";
		if (anyFieldValue.matches(regex)) {
			query.setParameter("idMax", GetMinOrMax.getMax(new Long(anyFieldValue), 5));
			query.setParameter("idMin", GetMinOrMax.getMin(new Long(anyFieldValue), 5));
		} else {
			query.setParameter("idMax", new Long(0));
			query.setParameter("idMin", new Long(0));
		}
		return query.getResultList();
	}

	@Override
	public List<RouteEntity> findByName(final String name) {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.FIND_ROUTE_BY_NAME, RouteEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public List<RouteEntity> findBySDest(final String sDest) {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.FIND_ROUTE_BY_S_DEST, RouteEntity.class);
		query.setParameter("sDest", sDest);
		return query.getResultList();
	}

	@Override
	public List<RouteEntity> findByEDest(final String eDest) {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.FIND_ROUTE_BY_E_DEST, RouteEntity.class);
		query.setParameter("eDest", eDest);
		return query.getResultList();
	}

	@Override
	public RouteEntity createOrUpdateRoute(RouteEntity routeEntity) {
		em.persist(routeEntity);
		return routeEntity;
	}

	@Override
	public void deleteRoute(final RouteEntity routeEntity) {
		em.remove(routeEntity);
	}

	@Override
	public RouteEntity findOneById(Long id) {
		return em.find(RouteEntity.class, id);
	}

	@Override
	public List<RouteEntity> findAll() {
		return em.createNamedQuery(QueryConstant.FIND_ROUTE_ALL, RouteEntity.class).getResultList();
	}

	@Override
	public int coundByName(String name, Long id) {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.COUNT_ROUTE_BY_NAME, RouteEntity.class);
		query.setParameter("id", id);
		query.setParameter("name", name);
		return query.getResultList().size();
	}

	@Override
	public List<ScheduleEntity> getScheldulesById(Long id) {
		RouteEntity routeEntity = em.find(RouteEntity.class, id);
		return routeEntity.getSeheduleList();
	}
}
