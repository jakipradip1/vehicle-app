package com.jakipradip.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.jakipradip.entity.ScheduleEntity;

@Service
public class ScheduleDAOImpl implements ScheduleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ScheduleEntity> findLastTen() {
		TypedQuery<ScheduleEntity> query = em.createNamedQuery(QueryConstant.FIND_SCHEDULE_ALL, ScheduleEntity.class);
		query.setMaxResults(10);
		List<ScheduleEntity> listScheduleEntity = query.getResultList();
		return listScheduleEntity;
	}

	@Override
	public List<ScheduleEntity> findById(Long id) {
		TypedQuery<ScheduleEntity> query = em.createNamedQuery(QueryConstant.FIND_SCHEDULE_BY_ID, ScheduleEntity.class);
		query.setMaxResults(10);
		query.setParameter("max", GetMinOrMax.getMax(id, 8));
		query.setParameter("max", GetMinOrMax.getMin(id, 8));
		List<ScheduleEntity> listScheduleEntity = query.getResultList();
		return listScheduleEntity;
	}

	@Override
	public ScheduleEntity findOneById(Long id) {
		return em.find(ScheduleEntity.class, id);
	}

	@Override
	public ScheduleEntity updateSchedule(ScheduleEntity scheduleEntity) {
		em.persist(scheduleEntity);
		return scheduleEntity;
	}

	@Override
	public void deleteSchedule(ScheduleEntity scheduleEntity) {
		em.remove(scheduleEntity);
	}

	@Override
	public ScheduleEntity createSchedule(ScheduleEntity scheduleEntity) {
		// System.out.println("Print this line");
		Query query = em.createNativeQuery("SELECT SCHEDULE_ID.NEXTVAL FROM DUAL");

		BigDecimal scheduleId = (BigDecimal) query.getSingleResult();
		System.out.println("scheduleId" + scheduleId.longValue());
		scheduleEntity.setSecheduleId(scheduleId.longValue());
		em.persist(scheduleEntity);
		return scheduleEntity;
	}
}
