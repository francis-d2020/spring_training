package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "USER-CLIENT")
public interface UserClient {

    //here when we call the method below, the endpoint above will be executed with getMapping and then json is assigned
    //to User
    @GetMapping("/users")
    List<User> getUsers();

}