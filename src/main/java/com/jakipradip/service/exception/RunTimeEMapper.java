package com.jakipradip.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

//@Component
//@Provider
//@Produces(MediaType.APPLICATION_JSON)
public class RunTimeEMapper implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException rte) {
		ErrorResponse er = new ErrorResponse("ERR-410", rte.getMessage());
		return Response.status(410).entity(er).build();
	}
}
