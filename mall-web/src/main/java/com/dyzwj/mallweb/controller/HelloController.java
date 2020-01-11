package com.dyzwj.mallweb.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zwj
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2020年01月07日 10:19:00
 */

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignTest feignTest;

    @HystrixCommand(fallbackMethod = "helloFallback")
    @GetMapping("/hello")
    public String hello(){
        return restTemplate.getForObject("http://PRODUCT-SERVICE/hello",String.class);
    }

    public String helloFallback(){

        return "fallback";
    }

    @GetMapping("/port")
    public int port(){
        return feignTest.port();
    }


}
