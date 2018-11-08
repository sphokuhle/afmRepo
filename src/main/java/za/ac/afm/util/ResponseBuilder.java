package za.ac.afm.util;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Stateless
public class ResponseBuilder {
    public Response buildResponse(Status status, Object obj) {
        return Response.status(status).entity(obj).build();
    }
    
    public Response buildResponseError(String msg) {
    	return Response.status(Status.OK).entity(msg).build();
    }
}