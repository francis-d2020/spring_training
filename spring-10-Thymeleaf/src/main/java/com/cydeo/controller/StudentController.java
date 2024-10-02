package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

//@RequestMapping(value = "/register",method = RequestMethod.GET) //localhost:8080/student/register
//instead of above line we can simply write @getmapping,get means we retrieve data
    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";

    }

    //the regular welcome page: (welcome in html welcome example)
   /* @RequestMapping("/welcome")
    public String welcome(){

        return "student/welcome";
    }
    */

/*
//catching the parameter from the link(link1 in html welcome example)
@RequestMapping("/welcome")
public String welcome(@RequestParam int id){
    System.out.println(id);
    return "student/welcome";
}
*/

    //catching the parameter from the link(link2 in html welcome example)
    //for example= http://localhost:8080/student/welcome?name=ozzy
    @RequestMapping("/welcome")
    public String welcome(@RequestParam String name){
        System.out.println(name);
        return "student/welcome";
    }


    //example of using postMapping annotation
    // post means we are giving data
   //@RequestMapping(value = "/welcome",method = RequestMethod.POST) //localhost:8080/student/welcome?name=Ozzy
  /* @PostMapping("/welcome")
    public String welcome(@RequestParam String name){

        return "student/welcome";
    }

*/
}
