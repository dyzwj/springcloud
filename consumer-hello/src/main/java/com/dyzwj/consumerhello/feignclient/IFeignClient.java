package com.dyzwj.consumerhello.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zwj
 * @version 1.0.0
 * @ClassName IFeignClient.java
 * @Description TODO
 * @createTime 2020年01月04日 14:44:00
 */
@FeignClient(name = "PRODUCT-SERVICE")
public interface IFeignClient {

    @GetMapping("/hello")
    String hello();

}
