package se.ikea.payments.delayedcapture.persistence.repository;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import se.ikea.payments.delayedcapture.persistence.entity.Authorization;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorizationRepository extends CrudRepository<Authorization, String> {

    Optional<Authorization> findById(String iopgId);

}
