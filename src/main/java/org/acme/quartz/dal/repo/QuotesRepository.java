package org.acme.quartz.dal.repo;

import io.quarkus.arc.Unremovable;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.quartz.model.entity.QuotesEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Set;

@ApplicationScoped
@Unremovable
public class QuotesRepository implements PanacheRepositoryBase<QuotesEntity, String> {

    @Inject
    EntityManager em;

    @Transactional
    public void persistAll(Set<QuotesEntity> entities) {
        for (QuotesEntity entity : entities) {
            em.persist(entity);
        }
        em.flush();
    }
}
