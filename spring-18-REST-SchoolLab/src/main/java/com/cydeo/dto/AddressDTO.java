package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)//only include the non-null fields in the json response
public class AddressDTO {

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;

    //the names are to make the matching because without them it will be same default name for the 3
    //@JsonBackReference
    @JsonBackReference(value = "student-address-reference")          // defaultReference
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference")          // defaultReference
    private ParentDTO parent;

    @JsonBackReference(value = "teacher-address-reference")          // defaultReference
    private TeacherDTO teacher;

    private Integer currentTemperature;     // Weather information, which we will later get it from 3rd party API

}