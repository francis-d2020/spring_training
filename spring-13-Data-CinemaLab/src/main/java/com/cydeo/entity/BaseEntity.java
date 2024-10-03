package com.cydeo.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

//this class will be as parent to other classes, we don't want to create entity of it.
@MappedSuperclass
public class BaseEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

}
