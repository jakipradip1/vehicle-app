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

import com.jakipradip.service.RouteListVO;
import com.jakipradip.service.RouteService;
import com.jakipradip.service.ScheduleListVO;
import com.jakipradip.vo.RouteVO;

@Service
@Path(value = "/route")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RouteRest {

	@Autowired
	private RouteService routeService;

	// for testing rest
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "Route's Rest Working Sucessfully";
	}

	@POST
	public Response createRoute(final RouteVO routeVO) {
		RouteVO postedVO = routeService.createRoute(routeVO);
		return Response.ok().entity(postedVO).build();
	}

	@PUT
	public Response updateRoute(final RouteVO routeVO) {
		RouteVO updatedVO = routeService.updateRoute(routeVO);
		return Response.ok().entity(updatedVO).build();
	}

	@GET
	public Response getAllRoute() {
		RouteListVO listRouteVO = routeService.findAll();
		return Response.ok().entity(listRouteVO).build();
	}

	@GET
	@Path("/id")
	public Response getRouteById(@QueryParam("id") final Long id) {
		RouteListVO listRouteVO = routeService.findById(id);
		return Response.ok().entity(listRouteVO).build();
	}

	@GET
	@Path("/scheldules/{id}")
	public Response getScheldulesByRouteId(@PathParam("id") final Long id) {
		ScheduleListVO listScheduleVO = routeService.getScheldulesById(id);
		return Response.ok().entity(listScheduleVO).build();
	}

	@GET
	@Path("/name")
	public Response getRouteByName(@QueryParam("name") final String name) {
		RouteListVO listRouteVO = routeService.findByName(name);
		return Response.ok().entity(listRouteVO).build();
	}

	@GET
	@Path("/anyField")
	public Response getRouteByAnyField(@QueryParam("anyField") final String anyField) {
		RouteListVO listRouteVO = routeService.findByAnyField(anyField);
		return Response.ok().entity(listRouteVO).build();
	}

	@GET
	@Path("/sDest")
	public Response getRouteBySDest(@QueryParam("sDest") final String sDest) {
		RouteListVO listRouteVO = routeService.findBySDest(sDest);
		return Response.ok().entity(listRouteVO).build();
	}

	@GET
	@Path("/eDest")
	public Response getRouteByEDest(@QueryParam("eDest") final String eDest) {
		RouteListVO listRouteVO = routeService.findByEDest(eDest);
		return Response.ok().entity(listRouteVO).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteRoute(@PathParam("id") final Long id) {
		routeService.deleteRoute(id);
		return Response.noContent().build();
	}
}
