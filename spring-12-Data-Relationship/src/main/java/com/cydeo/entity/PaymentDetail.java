package com.cydeo.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
//**when we work with entities we need no args
@Entity
@Table(name = "paymentDetails")
@NoArgsConstructor
@Data
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    //mappedBy means not to create foreign key inside the class table
    //and give the ownership(having the foreign key)to the payment table.
    @OneToOne(mappedBy = "paymentDetail")
    private Payment payment;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}
