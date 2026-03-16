package com.inventra.service;

import com.inventra.dto.TransactionFilterRequest;
import com.inventra.model.InventoryTransaction;
import com.inventra.repository.InventoryTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionFilteringService {

    @Autowired
    private InventoryTransactionRepository repository;

    public List<InventoryTransaction> getFilteredTransactions(TransactionFilterRequest request) {

        List<InventoryTransaction> transactions = repository.findAll();

        if (request.getProductId() != null) {
            transactions = transactions.stream()
                    .filter(t -> t.getProduct() != null &&
                            t.getProduct().getId().equals(request.getProductId()))
                    .collect(Collectors.toList());
        }

        if (request.getTransactionType() != null) {
            transactions = transactions.stream()
                    .filter(t -> t.getType() != null &&
                            t.getType().name().equals(request.getTransactionType()))
                    .collect(Collectors.toList());
        }

        if (request.getUser() != null) {
            transactions = transactions.stream()
                    .filter(t -> request.getUser().equals(t.getPerformedBy()))
                    .collect(Collectors.toList());
        }

        if (request.getMinQuantity() != null) {
            transactions = transactions.stream()
                    .filter(t -> t.getQuantity() >= request.getMinQuantity())
                    .collect(Collectors.toList());
        }

        return transactions;
    }
}