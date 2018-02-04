package com.sjabonir;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Endpoint {
    @GET
    @Path(value = "/test/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTest(@HeaderParam("Authorization") String authString);
}
