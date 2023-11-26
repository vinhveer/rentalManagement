package com.vinhveer.rentalmanagement.controller;

import com.vinhveer.rentalmanagement.payload.request.RoleRequest;
import com.vinhveer.rentalmanagement.repository.RoleRepository;
import com.vinhveer.rentalmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAll() {
        return roleService.GetAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> Add(@RequestBody RoleRequest roleRequest) {
        return roleService.Add(roleRequest);
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetByID(@PathVariable long id) {
        return roleService.GetByID(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteByID(@PathVariable long id) {
        return roleService.DeleteByID(id);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Object> EditByID(@RequestBody RoleRequest roleRequest, @PathVariable long id) {
        return roleService.EditByID(roleRequest, id);
    }
}