package com.study_dio.eberte.domain.controller;

import com.study_dio.eberte.domain.entity.User;
import com.study_dio.eberte.service.UserServiceInterface;
import com.study_dio.eberte.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> allClients(){
        return this.userService.all();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public User findById(@PathVariable Long id){
        return this.userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> create(@RequestBody User newUser) {
        var userCreated = this.userService.create(newUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);
    }
}
