package org.acme.quartz.job;

import io.quarkus.arc.Arc;
import org.acme.quartz.client.QuotesResource;
import org.acme.quartz.model.dto.QuoteDto;
import org.acme.quartz.scheduler.QuartzScheduler;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class UpdateJob implements Job{
    @Inject
    QuartzScheduler quartzScheduler;
    @Inject
    QuotesResource extensionsResource;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        try {
                QuoteDto result = extensionsResource.symbol(); //"AAPL","cgc8dshr01qsquh3g6a0cgc8dshr01qsquh3g6ag"
                quartzScheduler.saveExtension(result);
            } catch (Exception e) {
                 System.out.println("Exception -->"+e);
            }
    }
}
