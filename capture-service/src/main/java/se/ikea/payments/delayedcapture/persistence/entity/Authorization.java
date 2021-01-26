package se.ikea.payments.delayedcapture.persistence.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="payment_authorization")
@Data
public class Authorization {

    @Id
    private UUID iopgId;

    @Column(name = "retail_unit")
    private String reatilUnit;

    @Column(name = "reconciliation_id")
    private String reconciliationId;

    @Column(name = "psp_reference_id")
    private String pspReferenceId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "authorization_timestamp")
    private Timestamp authorizationTimestamp;

    @Column(name = "received_timestamp")
    private Timestamp receivedTimestamp;

}
