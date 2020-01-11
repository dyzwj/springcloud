package com.dyzwj.productservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * @author zwj
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2020年01月03日 19:03:00
 */

@RestController
public class HelloController {




    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, Spring Cloud! My port is " + String.valueOf(serverPort);

    }

}
