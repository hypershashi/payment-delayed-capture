package se.ikea.payments.delayedcapture.logging.fields;

public class OtherFields {
    public static final String IOPG_ID = "iopgId";
    public static final String TIMESPENT_MS = "timeSpentMs";
    public static final String SESSION_IDENTIFIER = "sessionIdentifier";
    public static final String RESPONSE_PAYLOAD = "responsePayload";
    public static final String REQUEST_PAYLOAD = "requestPayload";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String ERROR_CODE = "errorCode";
    public static final String RECONCILIATION_ID = "reconciliationId";
    public static final String PUBSUB_MESSAGE_ID = "pubsubMessageId";
    public static final String EVENT_TYPE = "eventType";

    private OtherFields() {
        throw new IllegalStateException("Utility class");
    }
}
