package com.inventra.repository;

import com.inventra.model.InventoryTransaction;
import com.inventra.model.TransactionType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryTransactionRepository
        extends JpaRepository<InventoryTransaction, Long> {

    /* ================= PRODUCT HISTORY ================= */

    List<InventoryTransaction> findByProductId(Long productId);

    /* ================= DASHBOARD HISTORY ================= */

    List<InventoryTransaction> findTop20ByOrderByTransactionDateDesc();

    List<InventoryTransaction> findAllByOrderByTransactionDateDesc();


    /* ================= ANALYTICS ================= */

    @Query("SELECT COALESCE(SUM(t.quantity),0) FROM InventoryTransaction t WHERE t.type = com.inventra.model.TransactionType.STOCK_IN")
    Long getTotalStockIn();

    @Query("SELECT COALESCE(SUM(t.quantity),0) FROM InventoryTransaction t WHERE t.type = com.inventra.model.TransactionType.STOCK_OUT")
    Long getTotalStockOut();


    /* ================= FILTERING ================= */

    List<InventoryTransaction> findByType(TransactionType type);
    List<InventoryTransaction> findTop10ByOrderByTransactionDateDesc();
    

    
    @Query("SELECT MONTH(t.transactionDate), SUM(t.quantity) " +
           "FROM InventoryTransaction t " +
           "WHERE t.type = com.inventra.model.TransactionType.STOCK_OUT " +
           "GROUP BY MONTH(t.transactionDate)")
    List<Object[]> getMonthlyUsage();

}