package com.example.demo.service;

import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Value("$spring.datasource.url")
    private String jdbcUrl;


    public List<String> countOrders(Long id) {
        return orderRepository.countOrdersGroupByCustomers();
    }
}
