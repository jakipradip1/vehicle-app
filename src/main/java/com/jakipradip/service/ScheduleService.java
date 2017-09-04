package com.jakipradip.service;

import java.util.List;

import com.jakipradip.vo.ScheduleInputVO;
import com.jakipradip.vo.ScheduleOutputVO;

public interface ScheduleService {
	List<ScheduleOutputVO> findLastTen();

	List<ScheduleOutputVO> findById(final Long id);

	void deleteSchedule(final Long id);

	ScheduleOutputVO createSchedule(ScheduleInputVO scheduleInputVO);

	ScheduleOutputVO updateSchedule(ScheduleInputVO scheduleInputVO);
}
