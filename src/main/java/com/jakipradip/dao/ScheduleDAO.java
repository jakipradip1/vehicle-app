package com.jakipradip.dao;

import java.util.List;

import com.jakipradip.entity.ScheduleEntity;

public interface ScheduleDAO {
	List<ScheduleEntity> findLastTen();

	List<ScheduleEntity> findById(final Long id);

	ScheduleEntity findOneById(final Long id);

	ScheduleEntity updateSchedule(final ScheduleEntity scheduleEntity);

	ScheduleEntity createSchedule(final ScheduleEntity scheduleEntity);

	void deleteSchedule(final ScheduleEntity scheduleEntity);
}
