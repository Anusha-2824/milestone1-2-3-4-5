package com.inventra.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_transactions")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Integer quantity;

    private Integer balanceAfterTransaction;

    private String referenceNote;

    private String performedBy;

    private LocalDateTime transactionDate = LocalDateTime.now();

    public InventoryTransaction(){}

    public Long getId(){ return id; }

    public Product getProduct(){ return product; }

    public TransactionType getType(){ return type; }

    public Integer getQuantity(){ return quantity; }

    public Integer getBalanceAfterTransaction(){ return balanceAfterTransaction; }

    public String getReferenceNote(){ return referenceNote; }

    public String getPerformedBy(){ return performedBy; }

    public LocalDateTime getTransactionDate(){ return transactionDate; }

    public void setProduct(Product product){ this.product = product; }

    public void setType(TransactionType type){ this.type = type; }

    public void setQuantity(Integer quantity){ this.quantity = quantity; }

    public void setBalanceAfterTransaction(Integer balanceAfterTransaction){
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public void setReferenceNote(String referenceNote){
        this.referenceNote = referenceNote;
    }

    public void setPerformedBy(String performedBy){
        this.performedBy = performedBy;
    }

    public void setTransactionDate(LocalDateTime transactionDate){
        this.transactionDate = transactionDate;
    }

}