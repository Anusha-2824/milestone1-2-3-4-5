package com.inventra.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventra.model.Product;
import com.inventra.repository.ProductRepository;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
public class ReportController {

@Autowired
private ProductRepository repo;

@GetMapping("/generate")
public Map<String,Integer> generate(){

Map<String,Integer> data=new HashMap<>();

List<Product> products=repo.findAll();

for(Product p:products){
data.put(p.getName(),p.getStockQuantity());
}

return data;
}

}