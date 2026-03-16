package com.inventra.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

public class Report {

    private Long reportId;
    private String reportType;
    private LocalDateTime generatedDate;

    private Map<String, Object> filtersApplied;
    private Map<String, Object> dataSummary;
    private Map<String, Object> chartData;

    private List<String> recommendations;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDateTime getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }

    public Map<String, Object> getFiltersApplied() {
        return filtersApplied;
    }

    public void setFiltersApplied(Map<String, Object> filtersApplied) {
        this.filtersApplied = filtersApplied;
    }

    public Map<String, Object> getDataSummary() {
        return dataSummary;
    }

    public void setDataSummary(Map<String, Object> dataSummary) {
        this.dataSummary = dataSummary;
    }

    public Map<String, Object> getChartData() {
        return chartData;
    }

    public void setChartData(Map<String, Object> chartData) {
        this.chartData = chartData;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }
}