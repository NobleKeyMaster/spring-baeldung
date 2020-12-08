package com.example.demo.controller;


import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/getId/{id}")
    public List<String> hello(@PathVariable("id")Long id) {
        List<String> ordersCount = orderRepository.countOrdersGroupByCustomers();
        return ordersCount;
    }
}
