package com.example.demo.repository;

import com.example.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select count(p)" +
            " from Product p " +
            "group by p.company")
    List<Integer> countAllGroupByCompany();


    @Query("select p.company as company, sum(p.price) as total_price " +
            "from Product p " +
            "group by p.company " +
            "having sum(p.price) > 50000")
    List<String> countPriceGroupByCompany();


    @Query("select p.price " +
            "from Product p " +
            "where p.price > (select avg(p.price) from Product p)")
    List<String> findAllProductsWherePriceGreaterThanAvg();


}
