package com.vinhveer.rentalmanagement.controller;

import com.vinhveer.rentalmanagement.repository.UserRepository;
import com.vinhveer.rentalmanagement.payload.request.UserRequest;
import com.vinhveer.rentalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserRequest userRequest) {
        return userService.Add(userRequest);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAll() {
        return userService.GetAll();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> getUserByID(@PathVariable long id) {
        return userService.GetByID(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> deleteUserByID(@PathVariable long id) {
        return userService.DeleteByID(id);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Object> editUserByID(@RequestBody UserRequest userRequest, @PathVariable long id) {
        return userService.EditByID(userRequest, id);
    }
}