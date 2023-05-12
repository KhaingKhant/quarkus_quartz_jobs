package org.acme.quartz.client;
import org.acme.quartz.model.dto.QuoteDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/quote")
@RegisterRestClient
public interface ExtensionsService {

    @GET
    QuoteDto getBySymbol(@QueryParam("symbol") String symbol, @QueryParam("token") String token);
}