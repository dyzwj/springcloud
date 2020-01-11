package com.dyzwj.userservice.controller;

import com.dyzwj.userservice.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    protected Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${server.port}")
    private int serverPort;

    @RequestMapping(value = "/{loginName}", method = RequestMethod.GET)
    public User detail(@PathVariable String loginName) {
        String memos = "I come form " + this.serverPort;
        return new User(loginName, loginName, "/avatar/default.png", memos);
    }



    @GetMapping("/port")
    public int port(){
        return serverPort;
    }

}
