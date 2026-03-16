package com.inventra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventra.model.Product;
import com.inventra.model.InventoryTransaction;
import com.inventra.model.TransactionType;
import com.inventra.repository.ProductRepository;
import com.inventra.repository.InventoryTransactionRepository;
import com.inventra.service.InventoryBroadcastService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

@Autowired
private ProductRepository repository;

@Autowired
private InventoryTransactionRepository transactionRepository;

@Autowired
private InventoryBroadcastService broadcaster;


/* ================= GET PRODUCTS ================= */

@GetMapping
public List<Product> getProducts(){
    return repository.findAll();
}


/* ================= ADD PRODUCT ================= */

@PostMapping
public Product addProduct(@RequestBody Product product){

    Product saved = repository.save(product);

    /* CREATE TRANSACTION */
    InventoryTransaction tx = new InventoryTransaction();
    tx.setProduct(saved);
    tx.setType(TransactionType.STOCK_IN);
    tx.setQuantity(saved.getStockQuantity());
    tx.setPerformedBy("admin");

    transactionRepository.save(tx);

    broadcaster.broadcastInventory(repository.findAll());

    return saved;
}


/* ================= UPDATE PRODUCT ================= */

@PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id, @RequestBody Product product){

    Product existing = repository.findById(id).orElseThrow();

    int oldStock = existing.getStockQuantity();

    existing.setName(product.getName());
    existing.setStockQuantity(product.getStockQuantity());
    existing.setMinStockLevel(product.getMinStockLevel());

    Product updated = repository.save(existing);

    int difference = product.getStockQuantity() - oldStock;

    if(difference != 0){

        InventoryTransaction tx = new InventoryTransaction();

        tx.setProduct(updated);
        tx.setQuantity(Math.abs(difference));
        tx.setPerformedBy("admin");

        if(difference > 0){
            tx.setType(TransactionType.STOCK_IN);
        } else {
            tx.setType(TransactionType.STOCK_OUT);
        }

        transactionRepository.save(tx);
    }

    broadcaster.broadcastInventory(repository.findAll());

    return updated;
}


/* ================= DELETE PRODUCT ================= */

@DeleteMapping("/{id}")
public void deleteProduct(@PathVariable Long id){

    Product product = repository.findById(id).orElseThrow();

    InventoryTransaction tx = new InventoryTransaction();
    tx.setProduct(product);
    tx.setType(TransactionType.STOCK_OUT);
    tx.setQuantity(product.getStockQuantity());
    tx.setPerformedBy("admin");

    transactionRepository.save(tx);

    repository.deleteById(id);

    broadcaster.broadcastInventory(repository.findAll());
}

@GetMapping("/low-stock")
public List<Product> getLowStockProducts(){
    return repository.findLowStockProducts();
}

}