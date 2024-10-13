package com.example.demo.backend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

public class GlobalResponseHandler {


    public static  ResponseEntity createResponse(Object payload, Object errorBean ,HttpStatus status){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("payload",payload);
        hashMap.put("error",errorBean);
        ResponseEntity response = new ResponseEntity(hashMap,status);
        return response;
    }

}
