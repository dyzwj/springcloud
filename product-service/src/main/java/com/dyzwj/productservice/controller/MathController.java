package com.dyzwj.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/add")
    public int add(@RequestParam Integer first, @RequestParam Integer second){

        return first + second;

    }


}
