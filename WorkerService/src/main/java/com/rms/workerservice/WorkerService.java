package com.rms.workerservice;

import com.rms.workerservice.health.TemplateHealthCheck;
import com.rms.workerservice.resource.WorkerServiceResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class WorkerService extends Service<WorkerServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new WorkerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<WorkerServiceConfiguration> bootstrap) {
        bootstrap.setName("worker-service");
    }

    @Override
    public void run(WorkerServiceConfiguration configuration,
                    Environment environment) {
    	final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new WorkerServiceResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }

}
