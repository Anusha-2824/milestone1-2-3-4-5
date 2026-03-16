package com.inventra.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.inventra.model.Product;

@Service
public class StockPredictionService {

public Map<String,Integer> predictStock(List<Product> products){

Map<String,Integer> result = new HashMap<>();

for(Product p : products){

int predicted = p.getStockQuantity() + (int)(Math.random()*15);

result.put(p.getName(), predicted);

}

return result;
}

}