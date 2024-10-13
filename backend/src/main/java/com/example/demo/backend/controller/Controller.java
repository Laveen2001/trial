package com.example.demo.backend.controller;

import com.example.demo.backend.bean.Bean;
import com.example.demo.backend.entity.User;
import com.example.demo.backend.service.Service;
import com.example.demo.backend.util.GlobalResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/get")
    public ResponseEntity helloWorld() {
        Bean b = new Bean();
        b.setAge("errorage");
        b.setName("errorname");
        return GlobalResponseHandler.createResponse("Hello World!",b,HttpStatus.OK);

    }

    @PostMapping("/post")
    public ResponseEntity post(@RequestBody User user){
        return GlobalResponseHandler.createResponse(service.insertUser(user),null,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") long id){
        return GlobalResponseHandler.createResponse(service.getUser(id),null,HttpStatus.FOUND);
    }



}

