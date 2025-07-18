package com.example.demo_model4.service;

import com.example.demo_model4.model.Product;
import com.example.demo_model4.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByType(Type types);
    Page<Product> findAll(Pageable pageable);
}
