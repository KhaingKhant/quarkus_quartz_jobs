package org.acme.quartz.scheduler;

import io.quarkus.arc.Arc;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.quartz.dal.repo.QuotesRepository;
import org.acme.quartz.job.UpdateJob;
import org.acme.quartz.model.dto.QuoteDto;
import org.acme.quartz.model.entity.QuotesEntity;
import org.quartz.*;

@ApplicationScoped
public class QuartzScheduler {
    @Inject
    org.quartz.Scheduler quartz;

    @Inject
    QuotesRepository quotesRepository;

    void onStart(@Observes StartupEvent startupEvent) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(UpdateJob.class)
                .withIdentity("ExtJob","ExtJobGroup")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("ExtJobTrigger","ExtJobGroup")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();
        quartz.scheduleJob(jobDetail, trigger);
    }
    @Transactional
    public void saveExtension(QuoteDto quoteDto) {
        QuotesEntity quoteEntity = new QuotesEntity();
        quoteEntity.setC(quoteDto.getC());
        quoteEntity.setD(quoteDto.getD());
        quoteEntity.setDp(quoteDto.getDp());
        quoteEntity.setH(quoteDto.getH());
        quoteEntity.setL(quoteDto.getL());
        quoteEntity.setO(quoteDto.getO());
        quoteEntity.setPc(quoteDto.getPc());
        quotesRepository.persist(quoteEntity);
    }
}
