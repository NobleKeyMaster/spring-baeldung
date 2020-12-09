package com.example.demo.controller;


import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class GreetingController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getId/{id}")
    public ResponseEntity<List<String>> hello(@PathVariable("id")Long id) {
        List<String> ordersCount = orderService.countOrders(id);

        return new ResponseEntity<>(ordersCount, HttpStatus.ACCEPTED);
    }
}
