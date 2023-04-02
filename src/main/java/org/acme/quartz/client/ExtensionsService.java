package org.acme.quartz.client;
import org.acme.quartz.model.dto.ExtensionDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;


@Path("/extensions")
@RegisterRestClient(baseUri = "https://stage.code.quarkus.io/api")
public interface ExtensionsService {

    @GET
    Set<ExtensionDto> getById(@QueryParam String id);
}