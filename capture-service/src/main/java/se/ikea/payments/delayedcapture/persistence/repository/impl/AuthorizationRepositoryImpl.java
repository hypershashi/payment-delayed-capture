package se.ikea.payments.delayedcapture.persistence.repository.impl;

import io.micronaut.data.annotation.Repository;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.transaction.annotation.ReadOnly;
import se.ikea.payments.delayedcapture.persistence.entity.Authorization;
import se.ikea.payments.delayedcapture.persistence.repository.AuthorizationRepository;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
public class AuthorizationRepositoryImpl{

    @PersistenceContext
    public final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public AuthorizationRepositoryImpl(EntityManager entityManager,
                                       ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @ReadOnly
    public Optional<Authorization> findByIopgId(String iopgId) {
        return Optional.ofNullable(entityManager.find(Authorization.class, iopgId));
    }

    @Transactional
    public Authorization save(@NotNull Authorization authorization) {
        entityManager.persist(authorization);

        return authorization;
    }

    @ReadOnly
    public List<Authorization> findByReconciliationId(String reconciliationId) {
        return entityManager.createQuery("select x from Authorization as x where reconciliationId = :reconciliationId", Authorization.class)
                .setParameter("reconciliationId", reconciliationId).getResultList();
    }
}
