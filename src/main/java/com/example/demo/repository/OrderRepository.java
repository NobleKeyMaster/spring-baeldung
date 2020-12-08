package com.example.demo.repository;

import com.example.demo.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o.productCount, o.price, o.productId, o.customerId, " +
            "p.isDiscounted, p.id, p.company, p.productCount, p.price, p.productName "+
            "FROM Order o " +
            "JOIN Product p " +
            "ON o.productId = p.id")
    List<String> joinToProducts();

    @Query("select o.productCount, o.price, o.productId, o.customerId, " +
            "c.id, c.FirstName, c.age, c.email, c.LastName " +
            "from Order o " +
            "left join Customer c " +
            "on o.customerId = c.id")
    List<String> leftJoin();


    @Query("select c.FirstName, o.id " +
            "from Customer c " +
            "join Order o on c.id = o.customerId")
    List<String> findCustomersByOrders();

    @Query("select c.FirstName, count (o.id) " +
            "from Customer c " +
            "join Order o " +
            "on c.id = o.customerId" +
            " group by c.FirstName")
    List<String> countOrdersGroupByCustomers();
}
