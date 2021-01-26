package se.ikea.payments.delayedcapture.messaging.subscribers;

import io.micronaut.gcp.pubsub.annotation.PubSubClient;
import io.micronaut.gcp.pubsub.annotation.PubSubListener;
import io.micronaut.gcp.pubsub.annotation.Subscription;
import io.swagger.model.IopgMessage;
import io.swagger.model.OpenInvoiceAuthorizedEvent;
import lombok.extern.slf4j.Slf4j;
import se.ikea.payments.delayedcapture.logging.fields.LogType;
import se.ikea.payments.delayedcapture.logging.fields.OtherFields;
import se.ikea.payments.delayedcapture.service.AuthorizationEventHandler;
import se.ikea.payments.delayedcapture.utils.Constants;

import static net.logstash.logback.argument.StructuredArguments.v;

@PubSubListener
@Slf4j
public class IOPGMessageSubscriber {

    private AuthorizationEventHandler authorizationEventHandler;

    public IOPGMessageSubscriber(AuthorizationEventHandler authorizationEventHandler) {
        this.authorizationEventHandler = authorizationEventHandler;
    }

    @Subscription(value="${messaging.iopg-messages-subscription}")
    public void onMessage(IopgMessage iopgMessage) {
        log.debug(Constants.LOG_RECEIVED_IOPG_MESSAGE,
                v(LogType.KEY, LogType.VALUE.INBOUND_MESSAGING),
                v(OtherFields.IOPG_ID, iopgMessage.getIopgId()),
                v(OtherFields.EVENT_TYPE, iopgMessage.getClass().getName()));
        if(iopgMessage instanceof OpenInvoiceAuthorizedEvent) {
            authorizationEventHandler.handleOpenInvoiceAuthorizationEvent((OpenInvoiceAuthorizedEvent)iopgMessage);
        } else {
            log.debug(Constants.LOG_RECEIVED_IOPG_MESSAGE_NOT_ELIGIBLE,
                    v(LogType.KEY, LogType.VALUE.INBOUND_MESSAGING),
                    v(OtherFields.IOPG_ID, iopgMessage.getIopgId()),
                    v(OtherFields.EVENT_TYPE, iopgMessage.getClass().getName()));
        }
    }

}
