package com.example.demo.controller;


import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
//    @Qualifier("orderServiceImpl1")
    private OrderService orderService;

    @GetMapping("/getId/{id}")
    public ResponseEntity<List<String>> hello(@PathVariable("id")Long id) {
        List<String> ordersCount = orderService.countOrders(id);

        return new ResponseEntity<>(ordersCount, HttpStatus.ACCEPTED);
    }
}
