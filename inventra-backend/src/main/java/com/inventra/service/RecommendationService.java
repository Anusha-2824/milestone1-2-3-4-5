package com.inventra.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecommendationService {

    public List<String> generateRecommendations(Map<String, Object> analytics) {

        List<String> recommendations = new ArrayList<>();

        int transactions = (int) analytics.get("transactionCount");

        if (transactions > 100) {
            recommendations.add("High inventory movement detected. Increase safety stock.");
        }

        if (transactions < 10) {
            recommendations.add("Low inventory activity detected. Review procurement.");
        }

        return recommendations;
    }
}