package com.dyzwj.consumerhello.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj
 * @version 1.0.0
 * @ClassName TestFeignClientController.java
 * @Description TODO
 * @createTime 2020年01月04日 14:48:00
 */

@RestController
public class TestFeignClientController {

    @Autowired
    private IFeignClient feignClient;

    @GetMapping("/aaa")
    public String hello(){
        return feignClient.hello();

    }

}
