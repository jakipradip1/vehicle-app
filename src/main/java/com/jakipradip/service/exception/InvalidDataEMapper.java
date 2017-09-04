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
public class InvalidDataEMapper implements ExceptionMapper<InvalidDataException> {

	@Override
	public Response toResponse(InvalidDataException ide) {
		ErrorResponse er = new ErrorResponse("ERR-420", ide.getMessage());
		return Response.status(420).entity(er).build();
	}
}
