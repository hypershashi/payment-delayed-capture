CREATE TABLE payment_authorization (
                                iopg_id uuid NOT NULL,
                                psp_reference_id varchar NOT NULL,
                                reconciliation_id varchar NOT NULL,
                                retail_unit varchar NOT NULL,
                                amount numeric NOT NULL,
                                currency varchar NOT NULL,
                                authorization_timestamp timestamp NOT NULL,
                                received_timestamp timestamp NOT NULL
);

create index payment_authorization_iopg_id_idx on payment_authorization(iopg_id);
create index payment_authorization_reconciliation_id_idx on payment_authorization(reconciliation_id);
create index payment_authorization_retail_unit_idx on payment_authorization(retail_unit);

CREATE TABLE confirmed_captures (
                                iopg_id uuid NOT NULL,
                                authorization_iopg_id uuid NOT NULL,
                                psp_reference_id varchar NOT NULL,
                                reconciliation_id varchar NOT NULL,
                                retail_unit varchar NOT NULL,
                                amount numeric NOT NULL,
                                currency varchar NOT NULL,
                                capture_timestamp timestamp NOT NULL,
                                received_timestamp timestamp NOT NULL
);

create index confirmed_captures_iopg_id_idx on confirmed_captures(iopg_id);
create index confirmed_captures_reconciliation_id_idx on confirmed_captures(reconciliation_id);
create index confirmed_captures_retail_unit_idx on confirmed_captures(retail_unit);