package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//a way to ignore multiple fields:
//@JsonIgnoreProperties(value = {"address", "country"}, ignoreUnknown = true)
//ignoreUnknown makes application to ignore completely unknown fields that come from api(better for security)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    @JsonIgnore//won't be able to send name or get name through request/ response
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    //@jsonIgnore ignores completely sow we won't be able to add userDTO when posting an account
    //but with @JsonBackReference we can add user information in a request but not going to see it in the response
    @JsonBackReference  // This field is not going to be serialized(userDTO will be hidden in json)
    private UserDTO user;

}
