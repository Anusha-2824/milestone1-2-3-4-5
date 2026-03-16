package com.inventra.service;

import com.inventra.model.InventoryTransaction;
import com.inventra.model.Product;
import com.inventra.model.TransactionType;
import com.inventra.repository.InventoryTransactionRepository;
import com.inventra.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private InventoryTransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    public void logTransaction(Long productId,
                               Integer quantity,
                               TransactionType type,
                               String user,
                               String note) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        InventoryTransaction transaction = new InventoryTransaction();

        transaction.setProduct(product);
        transaction.setType(type);
        transaction.setQuantity(quantity);
        transaction.setPerformedBy(user);
        transaction.setReferenceNote(note);
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);
    }
}