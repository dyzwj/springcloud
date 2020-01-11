package com.dyzwj.mallweb.controller;

import com.dyzwj.mallweb.domain.Product;
import com.dyzwj.mallweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mall")
public class MallController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> list(){
        return productService.findAll();

    }

    @GetMapping("/{itemcode}")
    public Product detail(@PathVariable("itemcode") String itemcode){
        return productService.loadByItemcode(itemcode);
    }




}
