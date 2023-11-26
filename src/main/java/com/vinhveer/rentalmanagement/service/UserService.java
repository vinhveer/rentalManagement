package com.vinhveer.rentalmanagement.service;

import com.vinhveer.rentalmanagement.payload.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<Object> GetAll();

    ResponseEntity<Object> Add(UserRequest userRequest);

    ResponseEntity<Object> GetByID(long id);

    ResponseEntity<Object> DeleteByID(long id);

    ResponseEntity<Object> EditByID(UserRequest userRequest, long id);
}