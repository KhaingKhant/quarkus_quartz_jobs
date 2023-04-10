package org.acme.quartz.client;

import org.acme.quartz.model.dto.QuoteDto;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Set;

@Path("/quote")
public class QuotesResource {
    @Inject
    @RestClient
    ExtensionsService extensionsService;

    @GET
    public QuoteDto symbol() {
        return extensionsService.getBySymbol("AAPL", "cgc8dshr01qsquh3g6a0cgc8dshr01qsquh3g6ag");
    }
}
