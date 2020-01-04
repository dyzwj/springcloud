package com.dyzwj.productservice.controller;

import com.dyzwj.productservice.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @GetMapping("/list")
    public List<Product> list(){
        return buildProducts();
    }

    @GetMapping("/{itemcode}")
    public Product detail(@PathVariable String itemcode){
        List<Product> products = buildProducts();
        for (Product product : products) {
            if(itemcode.equalsIgnoreCase(product.getItemCode())){
                return product;
            }
        }
        return null;
    }

    protected List<Product> buildProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("item-1", "测试商品-1", "TwoStepsFromJava", 100));
        products.add(new Product("item-2", "测试商品-2", "TwoStepsFromJava", 200));
        products.add(new Product("item-3", "测试商品-3", "TwoStepsFromJava", 300));
        products.add(new Product("item-4", "测试商品-4", "TwoStepsFromJava", 400));
        products.add(new Product("item-5", "测试商品-5", "TwoStepsFromJava", 500));
        products.add(new Product("item-6", "测试商品-6", "TwoStepsFromJava", 600));
        return products;
    }

}
