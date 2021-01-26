package se.ikea.payments.delayedcapture.logging.fields;

public class Operations {

    public static final String OPERATION = "operation";
    public enum V {
        PUBLISH_MESSAGE,
        CAPTURE,
        REVERSE;
    }

}
