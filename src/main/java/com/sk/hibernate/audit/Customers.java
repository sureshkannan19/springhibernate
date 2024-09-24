package com.sk.hibernate.audit;

import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable("CUSTOMERS_AUD")
public class Customers {

    @Id
    private Long customerId;

    private String customerName;

    @NotAudited
    private Long socialSecurityNum;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
//    @NotAudited
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PAYMENT_MODE")
    private Payments payment;

}
