package se.ikea.payments.delayedcapture.logging.fields;

public class LogType {

    public static final String KEY = "logType";

    private LogType() {
    }

    public enum VALUE {
        API_OPERATION,
        INTEGRATION,
        ERROR,
        OUTBOUND_MESSAGING,
        INBOUND_MESSAGING;
    }


}