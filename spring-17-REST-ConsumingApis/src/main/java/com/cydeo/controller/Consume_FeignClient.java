package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {
/*
    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    //we return the result as we costumed it in the ResponseWrapper
    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){

        return ResponseEntity.ok(new ResponseWrapper("UserList Retrieved",userClient.getUsers()));
    }

    //consuming api that requires header
    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){

        return ResponseEntity.ok(new ResponseWrapper("Employee retrieved",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));

    }

*/
}