package com.sk.hibernate.audit;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENTS")
@AllArgsConstructor
@NoArgsConstructor
//@Audited
//@AuditTable("PAYMENTS_AUD")
@ToString
public class Payments {

    @Id
    @Column(name= "PAYMENT_MODE")
    private String paymentMode;
    @Column(name= "ACCEPTABLE_COUNTRY")
    private String acceptableCountry;

}
