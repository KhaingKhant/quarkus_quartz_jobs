package org.acme.quartz.dal.repo;

import io.quarkus.arc.Unremovable;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.quartz.model.entity.ExtensionsEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@Unremovable
public class ExtensionsRepository implements PanacheRepositoryBase<ExtensionsEntity, String> {

    @Inject
    EntityManager em;

    @Transactional
    public void persistAll(Set<ExtensionsEntity> entities) {
        for (ExtensionsEntity entity : entities) {
            em.persist(entity);
        }
        em.flush();
    }
}
