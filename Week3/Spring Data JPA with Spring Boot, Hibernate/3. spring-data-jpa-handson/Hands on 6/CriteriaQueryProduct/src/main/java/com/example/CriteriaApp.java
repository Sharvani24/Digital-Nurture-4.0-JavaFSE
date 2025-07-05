package com.example;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CriteriaApp implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(CriteriaApp.class, args);
    }

    @Override
    public void run(String... args) {
        List<Product> filtered = productService.searchProducts(8, null, 2.5, "Windows");

        System.out.println("Filtered Products:");
        filtered.forEach(p -> System.out.println(p.getName() + " | RAM: " + p.getRam() + " | CPU: " + p.getCpuSpeed()));
    }
}
