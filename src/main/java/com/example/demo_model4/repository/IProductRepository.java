package com.example.demo_model4.repository;

import com.example.demo_model4.model.Product;
import com.example.demo_model4.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAllByType(Type types);
    Page<Product> findAll(Pageable pageable);
}
