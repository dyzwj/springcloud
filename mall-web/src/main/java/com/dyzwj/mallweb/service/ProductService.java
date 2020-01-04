package com.dyzwj.mallweb.service;


import com.dyzwj.mallweb.domain.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE",fallback = ProductServiceFallBack.class)
public interface ProductService {

    @GetMapping("/product/list")
    List<Product> findAll();

    @GetMapping("/product/{itemcode}")
    Product loadByItemcode(@PathVariable("itemcode") String itemcode);

}