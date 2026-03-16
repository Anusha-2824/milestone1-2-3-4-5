package com.inventra.controller;

import com.inventra.dto.TransactionFilterRequest;
import com.inventra.model.InventoryTransaction;
import com.inventra.service.TransactionFilteringService;
import com.inventra.repository.InventoryTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/transactions")
@CrossOrigin
public class TransactionController {

@Autowired
private TransactionFilteringService filteringService;

@Autowired
private InventoryTransactionRepository repository;

/* NORMAL DASHBOARD TRANSACTIONS */

@GetMapping
public List<InventoryTransaction> getAllTransactions(){
    return repository.findAll();
}

/* FILTER TRANSACTIONS */

@PostMapping("/filter")
public List<InventoryTransaction> filterTransactions(
        @RequestBody TransactionFilterRequest request) {

    return filteringService.getFilteredTransactions(request);
}
@GetMapping("/recent")
public List<InventoryTransaction> getRecentTransactions(){
    return repository.findTop10ByOrderByTransactionDateDesc();
}

@GetMapping("/monthly-usage")
public List<Object[]> getMonthlyUsage(){
    return repository.getMonthlyUsage();
}
}