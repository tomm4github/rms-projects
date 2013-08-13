package com.rms.rest;

import com.rms.rest.health.TemplateHealthCheck;
import com.rms.rest.resource.RestTemplateResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class RestTemplate extends Service<RestTemplateConfiguration> {
    public static void main(String[] args) throws Exception {
        new RestTemplate().run(args);
    }

    @Override
    public void initialize(Bootstrap<RestTemplateConfiguration> bootstrap) {
        bootstrap.setName("rest-template");
    }

    @Override
    public void run(RestTemplateConfiguration configuration,
                    Environment environment) {
    	final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new RestTemplateResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }

}
