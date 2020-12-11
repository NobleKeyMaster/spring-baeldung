package com.example.demo.service.impl;

import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class OrderServiceImpl1 implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Value("$spring.datasource.url")
    private String jdbcUrl;


    public List<String> countOrders(Long id) {
        return orderRepository.countOrdersGroupByCustomers();
    }
}
