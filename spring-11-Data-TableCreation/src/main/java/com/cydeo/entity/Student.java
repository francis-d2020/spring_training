package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
//name the sql table as "students"
@Table(name = "students")
public class Student {
@Id
//make postgres create the id(identity makes 1 2 3..)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "studentFirstName")
private String firstName;
//change the column name in the sql
@Column(name = "studentLastName")
private String LastName;
private String email;

//when we work with date/tim ewe need to add these definitions
@Column(columnDefinition = "DATE")
private LocalDate birthDate;

@Column(columnDefinition = "TIME")
private LocalTime birthTime;

@Column(columnDefinition = "TIMESTAMP")
private LocalDateTime birthDateTime;

//working with enums, ordinal is working with numbers.
@Enumerated(EnumType.STRING)
//@Enumerated(EnumType.ORDINAL)
private Gender gender;

//adding a field that we dont want add in the DB
@Transient
private String city;



}
