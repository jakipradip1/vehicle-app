package com.jakipradip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakipradip.service.ScheduleListVO;
import com.jakipradip.service.ScheduleService;
import com.jakipradip.vo.ScheduleInputVO;
import com.jakipradip.vo.ScheduleOutputVO;

@Service
@Path("/schedule")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScheduleRest {

	@Autowired
	private ScheduleService scheduleService;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "Schedule's Rest Working Sucessfully";
	}

	@GET
	public Response getLastTenSchedules() {
		List<ScheduleOutputVO> scheduleOutputVOList = scheduleService.findLastTen();
		ScheduleListVO scheduleListVO = new ScheduleListVO(scheduleOutputVOList);
		return Response.ok().entity(scheduleListVO).build();
	}

	@GET
	@Path("/id")
	public Response getById(@QueryParam("id") final Long id) {
		List<ScheduleOutputVO> scheduleOutputVOList = scheduleService.findById(id);
		return Response.ok().entity(scheduleOutputVOList).build();
	}

	@POST
	public Response createSchedule(final ScheduleInputVO scheduleInputVO) {
		ScheduleOutputVO scheduleOutputVO = scheduleService.createSchedule(scheduleInputVO);
		return Response.ok().entity(scheduleOutputVO).build();
	}

	@PUT
	public Response updateSchedule(final ScheduleInputVO scheduleInputVO) {
		ScheduleOutputVO scheduleOutputVO = scheduleService.updateSchedule(scheduleInputVO);
		return Response.ok().entity(scheduleOutputVO).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteSchedule(@PathParam("id") final Long id) {
		scheduleService.deleteSchedule(id);
		return Response.noContent().build();
	}
}
