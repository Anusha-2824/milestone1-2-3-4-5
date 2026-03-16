package com.inventra.service;

import com.inventra.model.InventoryTransaction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    public Map<String, Object> analyzeInventory(List<InventoryTransaction> transactions) {

        Map<String, Object> analytics = new HashMap<>();

        int totalMovement = transactions.stream()
                .mapToInt(t -> t.getQuantity())
                .sum();

        analytics.put("transactionCount", transactions.size());
        analytics.put("totalStockMovement", totalMovement);

        return analytics;
    }
}