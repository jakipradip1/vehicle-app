package com.jakipradip.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.jakipradip.entity.ScheduleEntity;
import com.jakipradip.entity.VehicleEntity;
import com.jakipradip.myEnum.ActiveStatus;

@Service
public class VehicleDAOImpl implements VehicleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<VehicleEntity> findByAnyField(final String anyFieldValue) {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.FIND_VEHICLE_BY_ANYFIELD,
				VehicleEntity.class);
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
	public List<VehicleEntity> findById(final Long id) {
		Long max = GetMinOrMax.getMax(id, 5);
		Long min = GetMinOrMax.getMax(id, 5);
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.FIND_VEHICLE_BY_ID, VehicleEntity.class);
		query.setParameter("min", min);
		query.setParameter("max", max);
		return query.getResultList();
	}

	@Override
	public List<VehicleEntity> findByActiveStatus(final String activeStatus) {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.FIND_VEHICLE_BY_ACTIVESTATUS,
				VehicleEntity.class);
		query.setParameter("activeStatus", activeStatus);
		return query.getResultList();
	}

	@Override
	public List<VehicleEntity> findByType(final String type) {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.FIND_VEHICLE_BY_TYPE, VehicleEntity.class);
		query.setParameter("type", type);
		return query.getResultList();
	}

	@Override
	public List<VehicleEntity> findByRegNum(final String regNum) {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.FIND_VEHICLE_BY_REGNUM,
				VehicleEntity.class);
		query.setParameter("regNum", regNum);
		return query.getResultList();
	}

	@Override
	public VehicleEntity createOrUpdateVehicle(final VehicleEntity vehicleEntity) {
		System.out.println(vehicleEntity);
		em.persist(vehicleEntity);
		System.out.println(vehicleEntity);
		return vehicleEntity;
	}

	@Override
	public void deleteVehicle(final VehicleEntity vehicleEntity) {
		em.remove(vehicleEntity);
	}

	@Override
	public VehicleEntity findOneById(Long id) {
		return em.find(VehicleEntity.class, id);
	}

	@Override
	public List<VehicleEntity> findAll() {
		return em.createNamedQuery(QueryConstant.FIND_VEHICLE_ALL, VehicleEntity.class).getResultList();
	}

	@Override
	public int countByRegNum(String regNum, Long id) {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.COUNT_VEHICLE_BY_REGNUM,
				VehicleEntity.class);
		query.setParameter("regNum", regNum);
		query.setParameter("id", id);
		return query.getResultList().size();
	}

	@Override
	public List<ScheduleEntity> getScheldulesById(Long id) {
		VehicleEntity vehicleEntity = em.find(VehicleEntity.class, id);
		return vehicleEntity.getSeheduleList();
	}

	@Override
	public VehicleEntity updateVehicleStatus(Long id) {
		VehicleEntity vehicleEntity = em.find(VehicleEntity.class, id);
		ActiveStatus activeStatus = (vehicleEntity.getActiveStatus() == ActiveStatus.ACTIVE) ? ActiveStatus.INACTIVE
				: ActiveStatus.ACTIVE;
		vehicleEntity.setActiveStatus(activeStatus);
		em.persist(vehicleEntity);
		return vehicleEntity;
	}
}
