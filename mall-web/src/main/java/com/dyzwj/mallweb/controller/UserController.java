package com.dyzwj.mallweb.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;



    @HystrixCommand(fallbackMethod = "addFallback")
    @GetMapping("/add")
    public int add(){
       return  restTemplate.getForEntity("http://PRODUCT-SERVICE/math/add?first=1&second=2",Integer.class).getBody();
    }

    public int addFallback(){

        return 0;

    }

}
