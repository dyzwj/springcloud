package com.dyzwj.mallweb.service;

import com.dyzwj.mallweb.domain.Product;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProductServiceFallBack implements ProductService {


    @Override
    public List<Product> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Product loadByItemcode(String itemcode) {
        return new Product("error", "未知", "TwoStepsFromJava-Fallback", 0);
    }
}
