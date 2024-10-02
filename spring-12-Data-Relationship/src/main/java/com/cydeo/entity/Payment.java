package com.cydeo.entity;

import com.cydeo.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;
  //we write the relation type between the tables payments
 //and payment details
 //  @OneToOne(cascade = CascadeType.ALL)//cascade means when we make any action in parent table(payment) it will
// also do the same for child(payment detail) like save,remove...
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})//persist=save
    //we change the name of the forging key column
   @JoinColumn(name = "payment_detail_id")
   private PaymentDetail paymentDetail;

    @ManyToOne//many payments for one merchant
    private Merchant merchant;


    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
