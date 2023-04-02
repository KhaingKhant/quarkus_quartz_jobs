package org.acme.quartz.scheduler;

import io.quarkus.arc.Arc;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.acme.quartz.dal.repo.ExtensionsRepository;
import org.acme.quartz.job.UpdateJob;
import org.acme.quartz.model.dto.ExtensionDto;
import org.acme.quartz.model.entity.ExtensionsEntity;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class QuartzScheduler {

    void onStart(@Observes StartupEvent startupEvent) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(UpdateJob.class)
                .withIdentity("ExtJob","ExtJobGroup")
                .build();
        jobDetail.getJobDataMap().put("quartzScheduler", this);

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("ExtJobTrigger","ExtJobGroup")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(1)
                        .repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
    @Transactional
    public void saveExtension(Set<ExtensionDto> extensionDtos) {
        ExtensionsRepository extensionsRepository = Arc.container().instance(ExtensionsRepository.class).get();
        Set<ExtensionsEntity> extensionEntities = extensionDtos.stream()
                .map(dto -> new ExtensionsEntity(dto.name, dto.shortName))//, dto.keywords
                .collect(Collectors.toSet());
        extensionsRepository.persistAll(extensionEntities);
    }
}
