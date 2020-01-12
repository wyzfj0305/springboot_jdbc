package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")

    public String addUser(@RequestBody User user){
        userService.createUser(user);
        return "success-ok";
    }

    @GetMapping("/findAll")
    public List<User> findAll(){

        return userService.getUserList();
    }

    @GetMapping("/findOne/{id}")

    public User findOne(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PutMapping("/updateUser/{id}")

    public String updateUser(@PathVariable("id") Long id,User user){

      userService.updateUser(id,user);

        return "success-update";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "success-delete";
    }

}
