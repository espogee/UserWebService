package com.example.mysqlspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteUser(@RequestParam Integer id){
        //Delete data by id
        userRepository.deleteById(id);
        return "ID: "+ id +" deleted";
    }

    @GetMapping(path="/user")
    public @ResponseBody User getUser(@RequestParam Integer id){
        //Find a single user by id
        return userRepository.findById(id).get();
    }

}
