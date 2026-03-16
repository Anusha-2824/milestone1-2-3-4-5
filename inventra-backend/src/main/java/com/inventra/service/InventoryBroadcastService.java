package com.inventra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.inventra.model.Product;

@Service
public class InventoryBroadcastService {

@Autowired
private SimpMessagingTemplate messagingTemplate;

public void broadcastInventory(List<Product> products){

messagingTemplate.convertAndSend("/topic/inventory", products);

}

}