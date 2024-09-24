package com.cydeo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

//declares that this class is parent to other entities
@MappedSuperclass
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
