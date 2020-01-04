package com.dyzwj.consumerhello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private DiscoveryClient discoveryClient;

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(){
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello",String.class).getBody();
    }


    @GetMapping("/hello1")
    public String hello1(){
        return restTemplate.getForEntity("http://PRODUCT-SERVICE/hello",String.class).getBody();
    }


    @GetMapping("/helloEx")
    public String helloEx(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("SERVICE-HELLO");
        try{
            URI helloUri = new URI("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello");
            logger.info("Target service uri = {}. ", helloUri.toString());
            return new RestTemplate().getForEntity(helloUri,String.class).getBody();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return "异常";
    }

    @GetMapping("/test")
    public List<ServiceInstance> test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("SERVICE-HELLO");
        return instances;

    }


}
