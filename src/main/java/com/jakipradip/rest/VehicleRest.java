package com.jakipradip.rest;

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
import com.jakipradip.service.VehicleListVO;
import com.jakipradip.service.VehicleService;
import com.jakipradip.vo.VehicleVO;

@Service
@Path(value = "/vehicle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleRest {

	@Autowired
	private VehicleService vehicleService;

	// for testing rest
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "Vehicle's Rest Working Sucessfully";
	}

	@POST
	public Response createVehicle(final VehicleVO vehicleVO) {
		VehicleVO createdVO = vehicleService.createVehicle(vehicleVO);
		return Response.ok().entity(createdVO).build();
	}

	@PUT
	public Response updateVehicle(final VehicleVO vehicleVO) {
		VehicleVO updatedVO = vehicleService.updateVehicle(vehicleVO);
		return Response.ok().entity(updatedVO).build();
	}

	@PUT
	@Path("/changeStatus")
	public Response updateVehicleStatus(final VehicleVO vehicleVO) {
		VehicleVO updatedVO = vehicleService.updateVehicleStatus(vehicleVO);
		return Response.ok().entity(updatedVO).build();
	}

	@GET
	public Response getAllVehicle() {
		VehicleListVO listVehicleVO = vehicleService.findAll();
		return Response.ok().entity(listVehicleVO).build();
	}

	@GET
	@Path("/activeStatus")
	public Response getRouteByActiveStatus(@QueryParam("activeStatus") final boolean activeStatus) {
		VehicleListVO listVehicleVO = vehicleService.findByActiveStatus(activeStatus);
		return Response.ok().entity(listVehicleVO).build();
	}

	@GET
	@Path("/id")
	public Response getRouteById(@QueryParam("id") final Long id) {
		VehicleListVO listVehicleVO = vehicleService.findById(id);
		return Response.ok().entity(listVehicleVO).build();
	}

	@GET
	@Path("/scheldules/{id}")
	public Response getScheldulesByVehicleId(@PathParam("id") final Long id) {
		ScheduleListVO listScheduleVO = vehicleService.getScheldulesById(id);
		return Response.ok().entity(listScheduleVO).build();
	}

	@GET
	@Path("/anyField")
	public Response getRouteByAnyField(@QueryParam("anyField") final String anyField) {
		VehicleListVO listVehicleVO = vehicleService.findByAnyField(anyField);
		return Response.ok().entity(listVehicleVO).build();
	}

	@GET
	@Path("/type")
	public Response getRouteByType(@QueryParam("type") final String type) {
		VehicleListVO listVehicleVO = vehicleService.findByType(type);
		return Response.ok().entity(listVehicleVO).build();
	}

	@GET
	@Path("/regNum")
	public Response getRouteByEegNum(@QueryParam("regNum") final String regNum) {
		VehicleListVO listVehicleVO = vehicleService.findByRegNum(regNum);
		return Response.ok().entity(listVehicleVO).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteVehicle(@PathParam("id") final Long id) {
		vehicleService.deleteVehicle(id);
		return Response.noContent().build();
	}
}
