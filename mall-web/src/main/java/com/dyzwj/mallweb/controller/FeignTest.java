package com.dyzwj.mallweb.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zwj
 * @version 1.0.0
 * @ClassName FeignTest.java
 * @Description TODO
 * @createTime 2020年01月10日 10:14:00
 */

@FeignClient(name = "user-service")
public interface FeignTest {

    @GetMapping("/user/port")
    public int port();
}

