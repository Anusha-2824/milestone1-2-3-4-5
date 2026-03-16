package com.inventra.service;

import com.inventra.model.InventoryTransaction;
import com.inventra.model.Report;
import com.inventra.repository.InventoryTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReportService {

    @Autowired
    private InventoryTransactionRepository repository;

    @Autowired
    private AnalyticsService analyticsService;

    @Autowired
    private RecommendationService recommendationService;

    public Report generateReport() {

        List<InventoryTransaction> transactions = repository.findAll();

        Map<String, Object> analytics = analyticsService.analyzeInventory(transactions);

        List<String> recommendations = recommendationService.generateRecommendations(analytics);

        Report report = new Report();

        report.setReportType("INVENTORY_REPORT");
        report.setGeneratedDate(LocalDateTime.now());
        report.setDataSummary(analytics);
        report.setRecommendations(recommendations);

        return report;
    }
}