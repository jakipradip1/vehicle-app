package com.jakipradip.service.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class DuplicateEMapper implements ExceptionMapper<DuplicateException> {

	@Override
	public Response toResponse(DuplicateException de) {
		ErrorResponse er = new ErrorResponse("ERR-400", de.getMessage());
		return Response.status(400).entity(er).build();
	}
}
