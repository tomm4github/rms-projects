package com.rms.rest.resource;

import com.rms.rest.core.State;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.concurrent.atomic.AtomicLong;

@Path("/rest-template")
@Produces(MediaType.APPLICATION_JSON)
public class RestTemplateResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public RestTemplateResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public State sayHello(@QueryParam("service-name") Optional<String> name) {
        return new State(counter.incrementAndGet(),
                          String.format(template, name.or(defaultName)));
    }
}
