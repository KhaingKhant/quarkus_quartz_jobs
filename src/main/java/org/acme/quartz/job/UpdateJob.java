package org.acme.quartz.job;

import io.quarkus.arc.Arc;
import org.acme.quartz.client.ExtensionsResource;
import org.acme.quartz.dal.repo.ExtensionsRepository;
import org.acme.quartz.model.dto.ExtensionDto;
import org.acme.quartz.model.entity.ExtensionsEntity;
import org.acme.quartz.scheduler.QuartzScheduler;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class UpdateJob implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
            try {
                ExtensionsResource extensionsResource = Arc.container().instance(ExtensionsResource.class).get();
                QuartzScheduler quartzScheduler = (QuartzScheduler) context.getJobDetail().getJobDataMap().get("quartzScheduler");
                Set<ExtensionDto> result = extensionsResource.id("io.quarkus:quarkus-rest-client");
                quartzScheduler.saveExtension(result);
//              ExtensionsRepository extensionRepository = Arc.container().instance(ExtensionsRepository.class).get();
//                System.out.println("Result-->"+result.toString());
//                extensionRepository.persist(result.stream().map(dto ->
//                        new ExtensionsEntity(dto.id, dto.name, dto.shortName, dto.keywords)).collect(Collectors.toList()));
            } catch (Exception e) {
                 System.out.println("eii-->"+e);
            }
    }


}
