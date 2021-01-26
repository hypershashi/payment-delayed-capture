package se.ikea.payments.delayedcapture.service;

import io.swagger.model.OpenInvoiceAuthorizedEvent;
import se.ikea.payments.delayedcapture.persistence.entity.Authorization;
import se.ikea.payments.delayedcapture.persistence.repository.AuthorizationRepository;
import se.ikea.payments.delayedcapture.utils.Utils;

import javax.inject.Singleton;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Singleton
public class AuthorizationEventHandler {

    private AuthorizationRepository authorizationRepository;

    public AuthorizationEventHandler(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    public void handleOpenInvoiceAuthorizationEvent(OpenInvoiceAuthorizedEvent event) {
        Authorization authorization = new Authorization();
        authorization.setIopgId(UUID.fromString(event.getIopgId()));
        authorization.setReatilUnit(event.getRetailUnit());
        authorization.setReconciliationId(event.getPayload().getTransactionDetails().getReconciliationId());
        authorization.setPspReferenceId(event.getId());
        authorization.setAmount(event.getPayload().getPaymentDetails().getAmount());
        authorization.setCurrency(event.getPayload().getPaymentDetails().getCurrency());
        authorization.setAuthorizationTimestamp(Utils.parseStringToTimestamp(event.getPayload().getTransactionDetails().getPspTimestamp()));
        authorization.setReceivedTimestamp(Timestamp.valueOf(LocalDateTime.now()));

        authorizationRepository.save(authorization);


    }

}
